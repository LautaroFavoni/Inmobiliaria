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

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Admin> createAdmin(@RequestBody AdminForCreation adminForCreation) {
        try {
            // Convertir el DTO a la entidad Admin
            Admin admin = new Admin();
            admin.setName(adminForCreation.getName());
            admin.setlastname(adminForCreation.getlastname()); // Refleja el cambio a lastname
            admin.setDni(adminForCreation.getDni());
            admin.setPassword(adminForCreation.getPassword());
            admin.setMail(adminForCreation.getMail());
            admin.setRole("ADMIN"); // Establecer el rol como "ADMIN"

            Admin createdAdmin = adminService.createAdmin(admin);
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @ResponseBody
    public List<Admin> getAllAdmins() {
        System.out.println("acallegue");
        return adminService.getAllAdmins();
    }
}
