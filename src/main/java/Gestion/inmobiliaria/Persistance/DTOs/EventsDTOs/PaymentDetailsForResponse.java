package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Payment;

import java.util.Date;

public class PaymentDetailsForResponse {
    private Date date;
    private String description;
    private boolean validada;
    private double amount;

    // Constructor, getters y setters
    public PaymentDetailsForResponse(Payment payment) {
        this.date = payment.getDate();
        this.description = payment.getDescripcion();
        this.validada = payment.isValidada();
        this.amount = payment.getAmount();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
