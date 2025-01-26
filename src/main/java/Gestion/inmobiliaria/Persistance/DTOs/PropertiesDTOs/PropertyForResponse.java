package Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs;

import Gestion.inmobiliaria.Persistance.entities.Property;

public class PropertyForResponse {
    private Long id;
    private String description;
    private String address;

    // Constructor, getters y setters
    public PropertyForResponse(Property property) {
        this.id = property.getId();
        this.description = property.getDescription();
        this.address = property.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
