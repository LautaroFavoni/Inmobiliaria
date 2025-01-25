package Gestion.inmobiliaria.Persistance.entities;
import jakarta.persistence.*;


@Entity
public class Tenant extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")  // Define la clave foránea en la tabla Property
    private Property property;

    // Getters and Setters
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
