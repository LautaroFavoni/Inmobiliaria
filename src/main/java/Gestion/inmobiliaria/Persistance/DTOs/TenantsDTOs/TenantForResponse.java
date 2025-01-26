package Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Tenant;

public class TenantForResponse {
    private Long id;
    private String name;
    private String lastname;
    private String mail;

    // Constructor, getters y setters
    public TenantForResponse(Tenant tenant) {
        this.id = tenant.getId();
        this.name = tenant.getName();
        this.lastname = tenant.getLastname();
        this.mail = tenant.getMail();
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
