package Gestion.inmobiliaria.Persistance.entities;


import jakarta.persistence.Entity;

@Entity
public class Payment extends Event {

    private Double amount;  // Monto del pago

    // Getters and Setters
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
