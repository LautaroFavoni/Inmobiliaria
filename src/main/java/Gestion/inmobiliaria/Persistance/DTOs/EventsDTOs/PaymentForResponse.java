package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos.OwnerForResponse;
import Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs.PropertyForResponse;
import Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs.TenantForResponse;
import Gestion.inmobiliaria.Persistance.entities.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentForResponse {
    private Long id;
    private OwnerForResponse owner;
    private PropertyForResponse property;
    private TenantForResponse tenant;
    private PaymentDetailsForResponse paymentDetails;
    private List<ImagenForResponse> imagenes; // Lista de imágenes asociadas


    // Constructor, getters y setters
    public PaymentForResponse(Payment payment) {
        this.id = payment.getId();
        this.owner = new OwnerForResponse(payment.getOwner());
        this.property = new PropertyForResponse(payment.getProperty());
        this.tenant = new TenantForResponse(payment.getTenant());
        this.paymentDetails = new PaymentDetailsForResponse(payment);
        // Convertir las imágenes a DTOs
        this.imagenes = payment.getImagenes() != null
                ? payment.getImagenes().stream().map(ImagenForResponse::new).collect(Collectors.toList())
                : new ArrayList<>();  // Si es null, inicializa una lista vacía
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OwnerForResponse getOwner() {
        return owner;
    }

    public void setOwner(OwnerForResponse owner) {
        this.owner = owner;
    }

    public PropertyForResponse getProperty() {
        return property;
    }

    public void setProperty(PropertyForResponse property) {
        this.property = property;
    }

    public TenantForResponse getTenant() {
        return tenant;
    }

    public void setTenant(TenantForResponse tenant) {
        this.tenant = tenant;
    }

    public PaymentDetailsForResponse getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsForResponse paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<ImagenForResponse> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenForResponse> imagenes) {
        this.imagenes = imagenes;
    }
}
