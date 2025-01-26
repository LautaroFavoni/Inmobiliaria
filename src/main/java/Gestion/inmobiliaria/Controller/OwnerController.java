package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos.OwnerForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.OwnersDtos.OwnerForUpdate;
import Gestion.inmobiliaria.Services.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOwner(@RequestBody OwnerForCreation ownerForCreation) {
        try {
            // Validar duplicados
            if (ownerService.existsByDni(ownerForCreation.getDni())) {
                return new ResponseEntity<>("DNI ya está en uso.", HttpStatus.BAD_REQUEST);
            }

            if (ownerService.existsByMail(ownerForCreation.getMail())) {
                return new ResponseEntity<>("Mail ya está en uso.", HttpStatus.BAD_REQUEST);
            }

            // Crear Owner
            ownerService.createOwner(ownerForCreation);
            return new ResponseEntity<>("Owner creado exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el Owner.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateOwner(@PathVariable Long id, @RequestBody OwnerForUpdate ownerForUpdate) {
        try {
            ownerService.updateOwner(id, ownerForUpdate);
            return new ResponseEntity<>("Owner actualizado exitosamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Owner.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
