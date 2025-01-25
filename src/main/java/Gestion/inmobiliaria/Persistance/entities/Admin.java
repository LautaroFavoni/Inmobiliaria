package Gestion.inmobiliaria.Persistance.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN") // Valor discriminador para Admin
public class Admin extends User {
    // No necesita atributos adicionales
}
