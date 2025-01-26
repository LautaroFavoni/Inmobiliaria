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
}
