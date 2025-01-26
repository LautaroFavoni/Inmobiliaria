package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;


import java.util.Date;

public class ContractDTO extends EventDTO {

    private Date endDate;

    // Getters and Setters
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
