package Gestion.inmobiliaria.Persistance.entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Tenant extends User {


    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Property> properties;

    // Getters and Setters
    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}

