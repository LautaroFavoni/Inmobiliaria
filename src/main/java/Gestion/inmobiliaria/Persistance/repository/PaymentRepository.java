package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}