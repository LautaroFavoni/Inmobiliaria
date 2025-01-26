package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs.TenantForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.TenantsDTOs.TenantForUpdate;
import Gestion.inmobiliaria.Services.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTenant(@RequestBody TenantForCreation tenantForCreation) {
        try {
            // Validar duplicados
            if (tenantService.existsByDni(tenantForCreation.getDni())) {
                return new ResponseEntity<>("DNI ya está en uso.", HttpStatus.BAD_REQUEST);
            }
            if (tenantService.existsByMail(tenantForCreation.getMail())) {
                return new ResponseEntity<>("Mail ya está en uso.", HttpStatus.BAD_REQUEST);
            }

            // Crear Tenant
            tenantService.createTenant(tenantForCreation);
            return new ResponseEntity<>("Tenant creado exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el Tenant.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateTenant(@PathVariable Long id, @RequestBody TenantForUpdate tenantForUpdate) {
        try {
            tenantService.updateTenant(id, tenantForUpdate);
            return new ResponseEntity<>("Tenant actualizado exitosamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Tenant.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
