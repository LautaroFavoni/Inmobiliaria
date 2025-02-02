package Gestion.inmobiliaria.Services;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OCRService {

    @Value("${tessdata.path}") // Ruta a la carpeta tessdata
    private String tessDataPath;

    public String extractTextFromImage(String imagePath) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath); // Especifica la ruta de los archivos de idioma
        tesseract.setLanguage("spa"); // Usar "spa" para español
        try {
            File imageFile = new File(imagePath);
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            throw new RuntimeException("Error al procesar la imagen con OCR: " + e.getMessage());
        }
    }
}