package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs.PropertyForCreation;
import Gestion.inmobiliaria.Persistance.DTOs.PropertiesDTOs.PropertyForUpdate;
import Gestion.inmobiliaria.Persistance.entities.Property;
import Gestion.inmobiliaria.Services.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProperty(@RequestBody PropertyForCreation propertyForCreation) {
        try {
            propertyService.createProperty(propertyForCreation);
            return new ResponseEntity<>("Propiedad creada exitosamente.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la propiedad.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateProperty(@PathVariable Long id, @RequestBody PropertyForUpdate propertyForUpdate) {
        try {
            propertyService.updateProperty(id, propertyForUpdate);
            return new ResponseEntity<>("Propiedad actualizada exitosamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la propiedad.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        try {
            Property property = propertyService.getPropertyById(id);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
