package Gestion.inmobiliaria.Persistance.DTOs;

public class UserForLogin {
    private String DNI;
    private String password;

    // Constructor vacío
    public UserForLogin() {}

    // Constructor con argumentos
    public UserForLogin(String DNI, String password) {
        this.DNI = DNI;
        this.password = password;
    }

    // Getters y Setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
