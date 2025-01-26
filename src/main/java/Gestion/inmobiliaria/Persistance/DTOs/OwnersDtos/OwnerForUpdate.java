package Gestion.inmobiliaria.Persistance.DTOs;

import java.util.List;

public class OwnerForUpdate {
    private String name;
    private String lastname;
    private String mail;
    private List<Long> propertyIds; // IDs de propiedades a asociar

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Long> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(List<Long> propertyIds) {
        this.propertyIds = propertyIds;
    }

    // Getters y Setters
}
