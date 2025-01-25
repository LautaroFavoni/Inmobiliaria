package Gestion.inmobiliaria.Persistance.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Contract extends Event {

    private Date endDate;  // Fecha de finalización del contrato

    // Getters and Setters
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


}
