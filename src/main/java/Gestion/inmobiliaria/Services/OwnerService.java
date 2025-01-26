package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos.OwnerForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos.OwnerForUpdate;
import Gestion.inmobiliaria.Persistance.entities.Owner;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.repository.OwnerRepository;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PropertyRepository propertyRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerService(OwnerRepository ownerRepository, PropertyRepository propertyRepository, PasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createOwner(OwnerForCreation ownerForCreation) {
        Owner owner = new Owner();
        owner.setName(ownerForCreation.getName());
        owner.setLastname(ownerForCreation.getLastname());
        owner.setDni(ownerForCreation.getDni());
        owner.setPassword(passwordEncoder.encode(ownerForCreation.getPassword()));
        owner.setMail(ownerForCreation.getMail());
        owner.setRole("OWNER");

        ownerRepository.save(owner);
    }

    public void updateOwner(Long id, OwnerForUpdate ownerForUpdate) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Owner no encontrado."));

        // Actualizar datos básicos
        owner.setName(ownerForUpdate.getName());
        owner.setLastname(ownerForUpdate.getLastname());
        owner.setMail(ownerForUpdate.getMail());

        // Actualizar propiedades asociadas
        if (ownerForUpdate.getPropertyIds() != null) {
            List<Property> properties = propertyRepository.findAllById(ownerForUpdate.getPropertyIds());
            if (properties.size() != ownerForUpdate.getPropertyIds().size()) {
                throw new IllegalArgumentException("Una o más propiedades no existen.");
            }
            owner.setProperties(properties);
        }

        ownerRepository.save(owner);
    }

    public boolean existsByDni(String dni) {
        return ownerRepository.existsByDni(dni);
    }

    public boolean existsByMail(String mail) {
        return ownerRepository.existsByMail(mail);
    }
}
