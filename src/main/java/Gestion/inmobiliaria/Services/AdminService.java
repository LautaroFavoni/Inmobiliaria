package Gestion.inmobiliaria.Services;
import Gestion.inmobiliaria.Persistance.DTOs.AdminForCreation;
import Gestion.inmobiliaria.Persistance.entities.Admin;
import Gestion.inmobiliaria.Persistance.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Crear un nuevo admin
    public Admin createAdmin(Admin admin) {
        // Encriptar la contraseña antes de guardarla
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    // Obtener todos los admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Validar si ya existe un admin con el mismo DNI
    public boolean existsByDni(String dni) {
        return adminRepository.existsByDni(dni);
    }

    // Validar si ya existe un admin con el mismo mail
    public boolean existsByMail(String mail) {
        return adminRepository.existsByMail(mail);
    }

    // Validar si existe un admin con el mismo DNI (excluyendo un ID específico)
    public boolean existsByDni(String dni, Long excludeId) {
        Optional<Admin> existingAdmin = adminRepository.findByDni(dni);
        return existingAdmin.isPresent() && !existingAdmin.get().getId().equals(excludeId);
    }

    // Validar si existe un admin con el mismo mail (excluyendo un ID específico)
    public boolean existsByMail(String mail, Long excludeId) {
        Optional<Admin> existingAdmin = adminRepository.findByMail(mail);
        return existingAdmin.isPresent() && !existingAdmin.get().getId().equals(excludeId);
    }

    // Validar si existe un admin con un ID específico
    public boolean existsById(Long id) {
        return adminRepository.existsById(id);
    }

    // Actualizar un admin existente
    public Admin updateAdmin(Long id, AdminForCreation updatedData) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin no encontrado con ID: " + id));

        // Actualizar los campos del admin
        existingAdmin.setName(updatedData.getName());
        existingAdmin.setLastname(updatedData.getlastname());
        existingAdmin.setDni(updatedData.getDni());
        existingAdmin.setMail(updatedData.getMail());

        // Encriptar la contraseña solo si es proporcionada en la actualización
        if (updatedData.getPassword() != null && !updatedData.getPassword().isEmpty()) {
            existingAdmin.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        }

        return adminRepository.save(existingAdmin);
    }
}

