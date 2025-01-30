package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ContractDTO extends EventDTO {

    private Date endDate; // Fecha de finalización del contrato
    private List<LocalDate> increaseDates; // Lista de fechas de aumento

    // Getters and Setters
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<LocalDate> getIncreaseDates() {
        return increaseDates;
    }

    public void setIncreaseDates(List<LocalDate> increaseDates) {
        this.increaseDates = increaseDates;
    }
}

