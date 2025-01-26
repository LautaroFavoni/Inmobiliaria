package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

        boolean existsByDni(String dni);

        boolean existsByMail(String mail);

        Optional<Admin> findByDni(String dni);

        Optional<Admin> findByMail(String mail);
}