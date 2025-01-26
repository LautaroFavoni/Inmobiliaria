package Gestion.inmobiliaria.Persistance.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  // Permite usar herencia entre clases (si lo vas a necesitar para otras entidades como Owner o Tenant)
public abstract class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")  // Cambiado a SEQUENCE
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)  // Definición de la secuencia
    private Long id;

    private String name;

    private String lastname;
    @Column(unique = true)
    private String dni;

    private String password;  // Preferible encriptar con BCrypt
    private String mail;
    private String role;  // Ejemplo: "OWNER", "TENANT"

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
