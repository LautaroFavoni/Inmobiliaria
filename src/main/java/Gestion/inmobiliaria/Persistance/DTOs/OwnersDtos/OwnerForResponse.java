package Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos;

import Gestion.inmobiliaria.Persistance.entities.Owner;

public class OwnerForResponse {
    private Long id;
    private String name;
    private String lastname;
    private String mail;

    // Constructor, getters y setters
    public OwnerForResponse(Owner owner) {
        this.id = owner.getId();
        this.name = owner.getName();
        this.lastname = owner.getLastname();
        this.mail = owner.getMail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
