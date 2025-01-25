package Gestion.inmobiliaria.Controller;


import Gestion.inmobiliaria.Persistance.DTOs.JwtResponse;
import Gestion.inmobiliaria.Persistance.DTOs.UserForLogin;
import Gestion.inmobiliaria.Persistance.entities.User;
import Gestion.inmobiliaria.Persistance.repository.UserRepository;
import Gestion.inmobiliaria.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth") // Prefijo claro para autenticación
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserForLogin loginUser) {
        Optional<User> optionalUser = userRepository.findByDni(loginUser.getDNI());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
                String token = jwtService.generateToken(user); // Usamos DNI como identificador
                return ResponseEntity.ok(new JwtResponse(token));
            }
        }
        // Mensaje genérico para no revelar información
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }

    @DeleteMapping("/deleteUser/{DNI}")
    public ResponseEntity<?> deleteUser(@PathVariable String DNI) {
        Optional<User> optionalUser = userRepository.findByDni(DNI);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}

