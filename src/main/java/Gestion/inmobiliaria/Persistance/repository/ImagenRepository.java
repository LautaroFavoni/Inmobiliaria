package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {
}