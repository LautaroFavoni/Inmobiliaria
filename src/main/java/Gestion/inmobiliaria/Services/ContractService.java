package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractForResponse;
import Gestion.inmobiliaria.Persistance.repository.ContractRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ContractRepository contractRepository;

    public ContractForResponse createContract(ContractDTO contractDTO) {
        // Buscar la propiedad por el ID
        Property property = propertyRepository.findById(contractDTO.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        // Obtener el Owner y el Tenant a partir de la propiedad
        Owner owner = property.getOwner();
        Tenant tenant = property.getTenant();

        // Crear el contrato
        Contract contract = new Contract();
        contract.setOwner(owner);
        contract.setTenant(tenant);
        contract.setProperty(property);
        contract.setDate(contractDTO.getDate());
        contract.setDescripcion(contractDTO.getDescripcion());
        contract.setValidada(contractDTO.isValidada());
        contract.setEndDate(contractDTO.getEndDate());
        contract.setIncreaseDates(contractDTO.getIncreaseDates()); // Asignar fechas de aumento

        // Guardar el contrato
        Contract savedContract = contractRepository.save(contract);

        // Convertir el contrato a un DTO de respuesta
        return new ContractForResponse(savedContract);
    }

    public List<ContractForResponse> getAllContracts() {
        // Obtener todos los contratos y convertirlos directamente a DTO
        return contractRepository.findAll().stream()
                .map(ContractForResponse::new) // Usar el constructor de ContractForResponse directamente
                .collect(Collectors.toList());
    }

}

