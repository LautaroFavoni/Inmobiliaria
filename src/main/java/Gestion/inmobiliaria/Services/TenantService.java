package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs.TenantForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs.TenantForUpdate;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Persistance.entities.Tenant;
import Gestion.inmobiliaria.Persistance.repository.PropertyRepository;
import Gestion.inmobiliaria.Persistance.repository.TenantRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final PropertyRepository propertyRepository;
    private final PasswordEncoder passwordEncoder;

    public TenantService(TenantRepository tenantRepository, PropertyRepository propertyRepository, PasswordEncoder passwordEncoder) {
        this.tenantRepository = tenantRepository;
        this.propertyRepository = propertyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createTenant(TenantForCreation tenantForCreation) {
        Tenant tenant = new Tenant();
        tenant.setName(tenantForCreation.getName());
        tenant.setLastname(tenantForCreation.getLastname());
        tenant.setDni(tenantForCreation.getDni());
        tenant.setPassword(passwordEncoder.encode(tenantForCreation.getPassword()));
        tenant.setMail(tenantForCreation.getMail());
        tenant.setRole("TENANT");

        tenantRepository.save(tenant);
    }

    public void updateTenant(Long id, TenantForUpdate tenantForUpdate) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tenant no encontrado."));

        // Actualizar datos básicos
        tenant.setName(tenantForUpdate.getName());
        tenant.setLastname(tenantForUpdate.getLastname());
        tenant.setMail(tenantForUpdate.getMail());


        // Actualizar propiedades asociadas
        if (tenantForUpdate.getPropertyIds() != null) {
            List<Property> properties = propertyRepository.findAllById(tenantForUpdate.getPropertyIds());
            if (properties.size() != tenantForUpdate.getPropertyIds().size()) {
                throw new IllegalArgumentException("Una o más propiedades no existen.");
            }
            tenant.setProperties(properties);
        }

        tenantRepository.save(tenant);
    }

    public boolean existsByDni(String dni) {
        return tenantRepository.existsByDni(dni);
    }

    public boolean existsByMail(String mail) {
        return tenantRepository.existsByMail(mail);
    }
}
