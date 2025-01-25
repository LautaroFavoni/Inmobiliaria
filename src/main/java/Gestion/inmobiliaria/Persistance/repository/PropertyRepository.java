package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}