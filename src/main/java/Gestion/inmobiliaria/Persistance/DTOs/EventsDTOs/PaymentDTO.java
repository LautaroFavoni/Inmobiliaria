package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;


public class PaymentDTO extends EventDTO {

    private Double amount;

    // Getters and Setters
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
