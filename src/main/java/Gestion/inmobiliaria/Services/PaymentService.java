package Gestion.inmobiliaria.Services;



import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentForResponse;
import Gestion.inmobiliaria.Persistance.entities.Payment;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;

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

        // Asignar los montos y descripciones, asegurándose de que no sean null
        payment.setAlquiler(paymentDTO.getAlquiler() != null ? paymentDTO.getAlquiler() : 0.0);
        payment.setAlquilerDescripcion(paymentDTO.getAlquilerDescripcion());

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

        // Convertir el Payment a un PaymentForResponse
        return new PaymentForResponse(savedPayment);
    }



    public PaymentForResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return new PaymentForResponse(payment);
    }

}
