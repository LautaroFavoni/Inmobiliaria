package Gestion.inmobiliaria.Services;



import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentForResponse;
import Gestion.inmobiliaria.Persistance.entities.Payment;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;

import Gestion.inmobiliaria.Persistance.repository.PaymentRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public PaymentForResponse createPayment(PaymentDTO paymentDTO) {
        // Buscar la propiedad por el ID
        Property property = propertyRepository.findById(paymentDTO.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

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
        payment.setAmount(paymentDTO.getAmount()); // Asignar el monto

        // Guardar el pago
        Payment savedPayment = paymentRepository.save(payment);

        // Convertir el Payment a un PaymentForResponse
        return new PaymentForResponse(savedPayment);
    }

    public PaymentForResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return new PaymentForResponse(payment);
    }

}
