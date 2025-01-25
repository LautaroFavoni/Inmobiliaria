package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}