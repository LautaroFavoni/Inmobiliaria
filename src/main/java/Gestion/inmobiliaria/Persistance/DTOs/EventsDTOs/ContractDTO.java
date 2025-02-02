package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ContractDTO extends EventDTO {

    private LocalDateTime endDate; // Fecha de finalización del contrato
    private List<LocalDate> increaseDates; // Lista de fechas de aumento

    // Getters and Setters
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<LocalDate> getIncreaseDates() {
        return increaseDates;
    }

    public void setIncreaseDates(List<LocalDate> increaseDates) {
        this.increaseDates = increaseDates;
    }


}

