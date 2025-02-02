package Gestion.inmobiliaria.Services;



import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentForResponse;
import Gestion.inmobiliaria.Persistance.entities.Payment;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;

import Gestion.inmobiliaria.Persistance.enums.PaymentStatus;
import Gestion.inmobiliaria.Persistance.repository.PaymentRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import jakarta.el.PropertyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private EmailService emailService;


    public PaymentForResponse createPayment(PaymentDTO paymentDTO) {
        // Buscar la propiedad por el ID
        Property property = propertyRepository.findById(paymentDTO.getPropertyId())
                .orElseThrow(() -> new PropertyNotFoundException("Property not found with ID: " + paymentDTO.getPropertyId()));

        // Obtener el Owner y el Tenant a partir de la propiedad
        Owner owner = property.getOwner();
        Tenant tenant = property.getTenant();

        // Crear el pago
        Payment payment = new Payment();
        payment.setOwner(owner);
        payment.setTenant(tenant);
        payment.setProperty(property);
        payment.setDate(paymentDTO.getDate());
        payment.setDescripcion(paymentDTO.getDescripcion());
        payment.setValidada(paymentDTO.isValidada());
        payment.setStatus(PaymentStatus.PENDIENTE_DE_PAGO);

        // Asignar los montos y descripciones, asegurándose de que no sean null
        payment.setAlquiler(paymentDTO.getAlquiler() != null ? paymentDTO.getAlquiler() : 0.0);
        payment.setAlquilerDescripcion(paymentDTO.getAlquilerDescripcion());

        payment.setGastoBancario(paymentDTO.getGastoBancario() != null ? paymentDTO.getGastoBancario() : 0.0);
        payment.setGastoBancarioDescripcion(paymentDTO.getGastoBancarioDescripcion());


        payment.setExpensas(paymentDTO.getExpensas() != null ? paymentDTO.getExpensas() : 0.0);
        payment.setExpensasDescripcion(paymentDTO.getExpensasDescripcion());

        payment.setLitoralGas(paymentDTO.getLitoralGas() != null ? paymentDTO.getLitoralGas() : 0.0 ) ;
        payment.setLitoralGasDescripcion(paymentDTO.getLitoralGasDescripcion());

        payment.setTgi(paymentDTO.getTgi() != null ? paymentDTO.getTgi() : 0.0);
        payment.setTgiDescripcion(paymentDTO.getTgiDescripcion());

        payment.setApi(paymentDTO.getApi() != null ? paymentDTO.getApi() : 0.0);
        payment.setApiDescripcion(paymentDTO.getApiDescripcion());

        payment.setAgua(paymentDTO.getAgua() != null ? paymentDTO.getAgua() : 0.0);
        payment.setAguaDescripcion(paymentDTO.getAguaDescripcion());

        payment.setEpe(paymentDTO.getEpe() != null ? paymentDTO.getEpe() : 0.0);
        payment.setEpeescripcion(paymentDTO.getEpeDescripcion());

        payment.setSeguro(paymentDTO.getSeguro() != null ? paymentDTO.getSeguro() : 0.0);
        payment.setSeguroDescripcion(paymentDTO.getSeguroDescripcion());

        payment.setHonorarios(paymentDTO.getHonorarios() != null ? paymentDTO.getHonorarios() : 0.0);
        payment.setHonorariosDescripcion(paymentDTO.getHonorariosDescripcion());

        payment.setSellados(paymentDTO.getSellados() != null ? paymentDTO.getSellados() : 0.0);
        payment.setSelladosDescripcion(paymentDTO.getSelladosDescripcion());

        payment.setActualizacionDeposito(paymentDTO.getActualizacionDeposito() != null ? paymentDTO.getActualizacionDeposito() : 0.0);
        payment.setActualizacionDepositoDescripcion(paymentDTO.getActualizacionDepositoDescripcion());

        payment.setDeuda(paymentDTO.getDeuda() != null ? paymentDTO.getDeuda() : 0.0);
        payment.setDeudaDescripcion(paymentDTO.getDeudaDescripcion());

        payment.setaFavor(paymentDTO.getaFavor() != null ? paymentDTO.getaFavor() : 0.0);
        payment.setaFavorDescripcion(paymentDTO.getaFavorDescripcion());

        payment.setOtros(paymentDTO.getOtros() != null ? paymentDTO.getOtros() : 0.0);
        payment.setOtrosDescripcion(paymentDTO.getOtrosDescripcion());

        // Guardar el pago
        Payment savedPayment = paymentRepository.save(payment);

        // Crear el mensaje del correo
        String subject = "Tienes un pago pendiente";
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append("Hola ").append(tenant.getName()).append(",\n\n")
                .append("Tienes un pago pendiente con los siguientes detalles:\n\n")
                .append("Descripción: ").append(payment.getDescripcion()).append("\n")
                .append("Fecha: ").append(payment.getDate()).append("\n");

// Agregar solo los conceptos con valores no nulos y mayores que 0.0
        if (payment.getAlquiler() != null && payment.getAlquiler() > 0.0) {
            textBuilder.append("Alquiler: ").append(payment.getAlquiler()).append(" - ").append(payment.getAlquilerDescripcion()).append("\n");
        }
        if (payment.getGastoBancario() != null && payment.getGastoBancario() > 0.0) {
            textBuilder.append("Gastos Bancarios: ").append(payment.getGastoBancario()).append(" - ").append(payment.getGastoBancarioDescripcion()).append("\n");
        }
        if (payment.getExpensas() != null && payment.getExpensas() > 0.0) {
            textBuilder.append("Expensas: ").append(payment.getExpensas()).append(" - ").append(payment.getExpensasDescripcion()).append("\n");
        }
        if (payment.getLitoralGas() != null && payment.getLitoralGas() > 0.0) {
            textBuilder.append("Litoral Gas: ").append(payment.getLitoralGas()).append(" - ").append(payment.getLitoralGasDescripcion()).append("\n");
        }
        if (payment.getTgi() != null && payment.getTgi() > 0.0) {
            textBuilder.append("TGI: ").append(payment.getTgi()).append(" - ").append(payment.getTgiDescripcion()).append("\n");
        }
        if (payment.getApi() != null && payment.getApi() > 0.0) {
            textBuilder.append("API: ").append(payment.getApi()).append(" - ").append(payment.getApiDescripcion()).append("\n");
        }
        if (payment.getAgua() != null && payment.getAgua() > 0.0) {
            textBuilder.append("Agua: ").append(payment.getAgua()).append(" - ").append(payment.getAguaDescripcion()).append("\n");
        }
        if (payment.getEpe() != null && payment.getEpe() > 0.0) {
            textBuilder.append("EPE: ").append(payment.getEpe()).append(" - ").append(payment.getEpeDescripcion()).append("\n");
        }
        if (payment.getSeguro() != null && payment.getSeguro() > 0.0) {
            textBuilder.append("Seguro: ").append(payment.getSeguro()).append(" - ").append(payment.getSeguroDescripcion()).append("\n");
        }
        if (payment.getHonorarios() != null && payment.getHonorarios() > 0.0) {
            textBuilder.append("Honorarios: ").append(payment.getHonorarios()).append(" - ").append(payment.getHonorariosDescripcion()).append("\n");
        }
        if (payment.getSellados() != null && payment.getSellados() > 0.0) {
            textBuilder.append("Sellados: ").append(payment.getSellados()).append(" - ").append(payment.getSelladosDescripcion()).append("\n");
        }
        if (payment.getActualizacionDeposito() != null && payment.getActualizacionDeposito() > 0.0) {
            textBuilder.append("Actualización Depósito: ").append(payment.getActualizacionDeposito()).append(" - ").append(payment.getActualizacionDepositoDescripcion()).append("\n");
        }
        if (payment.getDeuda() != null && payment.getDeuda() > 0.0) {
            textBuilder.append("Deuda: ").append(payment.getDeuda()).append(" - ").append(payment.getDeudaDescripcion()).append("\n");
        }
        if (payment.getaFavor() != null && payment.getaFavor() > 0.0) {
            textBuilder.append("A Favor: ").append(payment.getaFavor()).append(" - ").append(payment.getaFavorDescripcion()).append("\n");
        }
        if (payment.getOtros() != null && payment.getOtros() > 0.0) {
            textBuilder.append("Otros: ").append(payment.getOtros()).append(" - ").append(payment.getOtrosDescripcion()).append("\n");
        }

        textBuilder.append("\nTotal a pagar: ").append(payment.getTotal()).append("\n\n")
                .append("Por favor, realiza una transferencia a los siguientes datos:\n")
                .append("CBU: 1234567890123456789012\n") // Reemplaza con el CBU real
                .append("Alias: MI.ALIAS.BANCARIO\n")    // Reemplaza con el alias real
                .append("Nombre del titular de la cuenta: Nombre del Titular\n\n") // Reemplaza con el nombre real
                .append("Una vez realizado el pago, suba el comprobante en el siguiente link:\n")
                .append("link que todavía no está definido\n\n") // Reemplaza con el link real cuando esté disponible
                .append("Por favor, realiza el pago lo antes posible.\n\n")
                .append("Saludos,\n")
                .append("Tu Administrador");

        // Enviar el correo al Tenant
        emailService.sendEmail(tenant.getMail(), subject, textBuilder.toString());

        // Convertir el Payment a un PaymentForResponse
        return new PaymentForResponse(savedPayment);
    }



    public PaymentForResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return new PaymentForResponse(payment);
    }

}
