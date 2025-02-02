package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Persistance.entities.Payment;

import java.time.LocalDateTime;
import java.util.Date;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ContractDetailsForResponseDTO {

    private LocalDateTime date;
    private String description;
    private boolean validada;
    private LocalDateTime endDate;
    private List<LocalDate> increaseDates; // Lista de fechas de aumento

    // Constructor
    public ContractDetailsForResponseDTO(Contract contract) {
        this.date = contract.getDate();
        this.description = contract.getDescripcion();
        this.validada = contract.isValidada();
        this.endDate = contract.getEndDate();
        this.increaseDates = contract.getIncreaseDates(); // Obtener fechas de aumento
    }

    // Getters y Setters
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
