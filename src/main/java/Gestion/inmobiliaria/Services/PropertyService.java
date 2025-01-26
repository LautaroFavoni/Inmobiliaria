package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs.PropertyForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs.PropertyForUpdate;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;
import Gestion.inmobiliaria.Persistance.repository.OwnerRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import Gestion.inmobiliaria.Persistance.repository.TenantRepository;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final OwnerRepository ownerRepository;
    private final TenantRepository tenantRepository;

    public PropertyService(PropertyRepository propertyRepository, OwnerRepository ownerRepository, TenantRepository tenantRepository) {
        this.propertyRepository = propertyRepository;
        this.ownerRepository = ownerRepository;
        this.tenantRepository = tenantRepository;
    }

    public void createProperty(PropertyForCreation propertyForCreation) {
        Property property = new Property();
        property.setDescription(propertyForCreation.getDescription());
        property.setAddress(propertyForCreation.getAddress());

        // Validar y asignar propietario
        Owner owner = ownerRepository.findById(propertyForCreation.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado."));
        property.setOwner(owner);

        propertyRepository.save(property);
    }

    public void updateProperty(Long id, PropertyForUpdate propertyForUpdate) {
        // Buscar la propiedad a actualizar
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Propiedad no encontrada."));

        // Actualizar campos básicos
        if (propertyForUpdate.getDescription() != null) {
            property.setDescription(propertyForUpdate.getDescription());
        }

        if (propertyForUpdate.getAddress() != null) {
            property.setAddress(propertyForUpdate.getAddress());
        }

        // Validar y asignar nuevo propietario si corresponde
        if (propertyForUpdate.getOwnerId() != null) {
            Owner owner = ownerRepository.findById(propertyForUpdate.getOwnerId())
                    .orElseThrow(() -> new IllegalArgumentException("Propietario no encontrado."));

            // Si el propietario cambia
            if (!owner.equals(property.getOwner())) {
                // Si había un propietario anterior, eliminar la propiedad de su lista de propiedades
                if (property.getOwner() != null) {
                    property.getOwner().getProperties().remove(property);
                }

                // Asignar el nuevo propietario a la propiedad
                property.setOwner(owner);
                owner.getProperties().add(property);  // Agregar la propiedad a la lista del nuevo propietario
            }
        }

        // Validar y asignar inquilino si corresponde
        if (propertyForUpdate.getTenantId() != null) {
            Tenant tenant = tenantRepository.findById(propertyForUpdate.getTenantId())
                    .orElseThrow(() -> new IllegalArgumentException("Inquilino no encontrado."));

            // Si el inquilino cambia
            if (!tenant.equals(property.getTenant())) {
                // Si había un inquilino anterior, eliminar la propiedad de su lista de propiedades
                if (property.getTenant() != null) {
                    property.getTenant().getProperties().remove(property);
                }

                // Asignar el nuevo inquilino a la propiedad
                property.setTenant(tenant);
                tenant.getProperties().add(property);  // Agregar la propiedad a la lista del nuevo inquilino
            }
        }

        // Guardar la propiedad actualizada
        propertyRepository.save(property);
    }



    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Propiedad no encontrada."));
    }
}

