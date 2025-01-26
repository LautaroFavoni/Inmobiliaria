package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractForResponse;
import Gestion.inmobiliaria.Persistance.entities.*;

import Gestion.inmobiliaria.Persistance.repository.ContractRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        // Crear el pago
        Contract contract = new Contract();
        contract.setOwner(owner);
        contract.setTenant(tenant);
        contract.setProperty(property);
        contract.setDate(contractDTO.getDate());
        contract.setDescripcion(contractDTO.getDescripcion());
        contract.setValidada(contractDTO.isValidada());
        contract.setEndDate(contractDTO.getEndDate()); // Asignar fecha fin

        // Guardar el pago
        Contract savedContract = contractRepository.save(contract);

        // Convertir el Payment a un PaymentForResponse
        return new ContractForResponse(savedContract);
    }
}
