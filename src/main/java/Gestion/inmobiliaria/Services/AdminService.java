package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.entities.Admin;
import Gestion.inmobiliaria.Persistance.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword())); // Encriptar la contraseña
        return adminRepository.save(admin);
    }


    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

}
