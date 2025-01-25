package Gestion.inmobiliaria.Persistance.repository;

import Gestion.inmobiliaria.Persistance.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}