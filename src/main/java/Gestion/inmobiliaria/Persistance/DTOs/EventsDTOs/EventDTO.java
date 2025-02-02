package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public abstract class EventDTO {

    private Long id;
    private Long ownerId;
    private Long tenantId;
    private Long propertyId;
    private LocalDateTime date;
    private String descripcion;
    private boolean validada;
    private List<Long> imagenes; // Usamos solo los IDs de las imágenes asociadas

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public List<Long> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Long> imagenes) {
        this.imagenes = imagenes;
    }
}
