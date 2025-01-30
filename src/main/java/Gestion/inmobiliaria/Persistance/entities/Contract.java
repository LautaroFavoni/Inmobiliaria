package Gestion.inmobiliaria.Persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contract extends Event {

    private Date endDate;  // Fecha de finalización del contrato

    @ElementCollection // Indica que la lista será almacenada como una colección embebida
    @CollectionTable(name = "contract_increase_dates", joinColumns = @JoinColumn(name = "contract_id"))
    @Column(name = "increase_date")
    private List<LocalDate> increaseDates = new ArrayList<>(); // Lista de fechas de aumento

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
