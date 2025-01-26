package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.AdminForCreation;
import Gestion.inmobiliaria.Persistance.entities.Admin;
import Gestion.inmobiliaria.Services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Crear un nuevo Admin
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> createAdmin(@RequestBody AdminForCreation adminForCreation) {
        try {
            // Validar si existe alguien con el mismo dni
            if (adminService.existsByDni(adminForCreation.getDni())) {
                return new ResponseEntity<>("Ya existe un admin con ese DNI", HttpStatus.BAD_REQUEST);
            }

            // Validar si existe alguien con el mismo mail
            if (adminService.existsByMail(adminForCreation.getMail())) {
                return new ResponseEntity<>("Ya existe un admin con ese mail", HttpStatus.BAD_REQUEST);
            }

            // Convertir el DTO a la entidad Admin
            Admin admin = new Admin();
            admin.setName(adminForCreation.getName());
            admin.setLastname(adminForCreation.getlastname());
            admin.setDni(adminForCreation.getDni());
            admin.setPassword(adminForCreation.getPassword());
            admin.setMail(adminForCreation.getMail());
            admin.setRole("ADMIN");

            Admin createdAdmin = adminService.createAdmin(admin);
            return new ResponseEntity<>("Admin creado con ID: " + createdAdmin.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos los Admins
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        try {
            List<Admin> admins = adminService.getAllAdmins();
            return new ResponseEntity<>(admins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un Admin existente
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable Long id, @RequestBody AdminForCreation adminForCreation) {
        try {
            // Validar si existe el admin con ese ID
            if (!adminService.existsById(id)) {
                return new ResponseEntity<>("Admin no encontrado", HttpStatus.NOT_FOUND);
            }

            // Validar si el DNI ya está en uso por otro admin
            if (adminService.existsByDni(adminForCreation.getDni(), id)) {
                return new ResponseEntity<>("Ya existe un admin con ese DNI", HttpStatus.BAD_REQUEST);
            }

            // Validar si el mail ya está en uso por otro admin
            if (adminService.existsByMail(adminForCreation.getMail(), id)) {
                return new ResponseEntity<>("Ya existe un admin con ese mail", HttpStatus.BAD_REQUEST);
            }

            Admin updatedAdmin = adminService.updateAdmin(id, adminForCreation);
            return new ResponseEntity<>("Admin actualizado con ID: " + updatedAdmin.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

