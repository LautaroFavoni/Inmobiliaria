package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Persistance.entities.Payment;

import java.util.Date;

public class ContractDetailsForResponseDTO {

        private Date date;
        private String description;
        private boolean validada;
        private Date endDate;

    // Constructor, getters y setters
        public ContractDetailsForResponseDTO(Contract contract) {
            this.date = contract.getDate();
            this.description = contract.getDescripcion();
            this.validada = contract.isValidada();
            this.endDate = contract.getEndDate();
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

    // Getters and Setters
          public Date getEndDate() {
        return endDate;
    }

         public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    }