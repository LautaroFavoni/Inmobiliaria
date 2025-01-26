package Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs;


public class PropertyForCreation {
    private String description;
    private String address;
    private Long ownerId; // ID del propietario

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    // Getters y Setters
}
