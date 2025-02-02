package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Persistance.entities.Imagen;
import Gestion.inmobiliaria.Persistance.entities.Payment;
import Gestion.inmobiliaria.Persistance.enums.PaymentStatus;
import Gestion.inmobiliaria.Persistance.repository.ContractRepository;
import Gestion.inmobiliaria.Persistance.repository.ImagenRepository;
import Gestion.inmobiliaria.Persistance.repository.PaymentRepository;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private OCRService ocrService; // Servicio de OCR

    @Value("${upload.path}")
    private String uploadDir;  // Ruta donde se guardarán las imágenes

    // Método para cargar una imagen
    public String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("No se ha proporcionado ningún archivo.");
        }

        // Generar un nombre único para el archivo
        String uniqueFileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path path = new File(uploadDir + File.separator + uniqueFileName).toPath();

        // Crear la carpeta si no existe
        Files.createDirectories(path.getParent());

        // Guardar el archivo en el sistema de archivos
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return path.toString();  // Retornar la ruta del archivo guardado
    }

    // Asociar imagen a un Payment y procesar con OCR
    public void addImageToPayment(Long paymentId, MultipartFile file) throws IOException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        // Guardar la imagen y obtener la ruta
        String rutaImagen = saveImage(file);

        // Procesar la imagen con OCR
        String ocrText = ocrService.extractTextFromImage(rutaImagen);
        System.out.println("Texto extraído: " + ocrText);

        // Validar el texto extraído (monto y fecha)
        if (validateOCRText(ocrText, payment)) {
            payment.setStatus(PaymentStatus.APROBADO); // Cambiar a Aprobado
        } else {
            payment.setStatus(PaymentStatus.PENDIENTE_DE_VALIDACION_MANUAL); // Cambiar a Pendiente de validación manual
        }

        // Guardar la imagen en la base de datos
        Imagen imagen = new Imagen();
        imagen.setRuta(rutaImagen);
        imagen.setTipo(file.getContentType());
        imagen.setTamaño(file.getSize());
        imagen.setEvent(payment);  // Asociamos la imagen con el pago

        imagenRepository.save(imagen);
        paymentRepository.save(payment);
    }

    // Asociar imagen a un Contract (sin OCR)
    public void addImageToContract(Long contractId, MultipartFile file) throws IOException {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new RuntimeException("Contract not found"));

        // Guardar la imagen y obtener la ruta
        String rutaImagen = saveImage(file);

        Imagen imagen = new Imagen();
        imagen.setRuta(rutaImagen);
        imagen.setTipo(file.getContentType());
        imagen.setTamaño(file.getSize());
        imagen.setEvent(contract);  // Asociamos la imagen con el contrato

        imagenRepository.save(imagen);
    }

    // Método para validar el texto extraído con OCR
    private boolean validateOCRText(String ocrText, Payment payment) {
        // Validar el monto
        if (!validateAmount(ocrText, payment.getTotal())) {
            return false; // El monto no coincide
        }

        // Validar la fecha (mismo mes)
        // Validar la fecha (mismo mes)
        String paymentDateStr = payment.getDate().toString(); // "2024-01-09 21:00:00.0"
        String dateOnly = paymentDateStr.substring(0, 10);   // Extraer "2024-01-09"
        LocalDate paymentDate = LocalDate.parse(dateOnly);   // Parsear a LocalDate

        if (!validateDate(ocrText, paymentDate)) {
            return false; // La fecha no está en el mismo mes
        }


        return true; // El comprobante es válido
    }

    // Método para validar el monto
    private boolean validateAmount(String ocrText, double expectedAmount) {
        // Buscar el monto en el texto extraído
        Pattern amountPattern = Pattern.compile("\\d+(\\.\\d{1,2})?"); // Expresión regular para montos
        Matcher amountMatcher = amountPattern.matcher(ocrText);

        if (amountMatcher.find()) {
            String extractedAmountStr = amountMatcher.group();
            System.out.println("Monto extraído (texto): " + extractedAmountStr);

            double extractedAmount = Double.parseDouble(extractedAmountStr);
            System.out.println("Monto extraído (numérico): " + extractedAmount);

            // Normalizar el monto extraído (multiplicar por 1000 si es necesario)
            if (extractedAmount < expectedAmount / 100) {
                extractedAmount *= 1000; // Ajustar el monto
            }

            System.out.println("Monto normalizado: " + extractedAmount + " | Monto esperado: " + expectedAmount);

            // Comparar los montos normalizados
            return extractedAmount == expectedAmount; // El monto coincide
        }
        return false; // No se encontró el monto
    }

    // Método para validar la fecha (mismo mes)
    private boolean validateDate(String ocrText, LocalDate paymentDate) {
        // Buscar la fecha en el texto extraído (formato dd/MM/yyyy)
        Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher dateMatcher = datePattern.matcher(ocrText);

        if (dateMatcher.find()) {
            String extractedDateStr = dateMatcher.group();
            System.out.println("Fecha extraída (texto): " + extractedDateStr);

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate extractedDate = LocalDate.parse(extractedDateStr, formatter);
                System.out.println("Fecha extraída (LocalDate): " + extractedDate);
                System.out.println("Fecha del pago (LocalDate): " + paymentDate);

                // Comparar solo año y mes
                boolean isSameMonthAndYear = extractedDate.getYear() == paymentDate.getYear() &&
                        extractedDate.getMonth() == paymentDate.getMonth();

                System.out.println("Validación de mes y año: " + isSameMonthAndYear);
                return isSameMonthAndYear;

            } catch (Exception e) {
                System.out.println("Error al parsear la fecha extraída: " + extractedDateStr);
                e.printStackTrace();
                return false;
            }
        }

        System.out.println("No se encontró ninguna fecha en el OCR.");
        return false;
    }

}