package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Imagen;

import java.util.Base64;

public class ImagenForResponse {
    private Long id;
    private String tipo;
    private double tamaño;

    private String datos; // Campo para los datos codificados en Base64


    public ImagenForResponse(Imagen imagen) {
        this.id = imagen.getId();
        this.tipo = imagen.getTipo();
        this.tamaño = imagen.getTamaño();
        this.datos = Base64.getEncoder().encodeToString(imagen.getDatos()); // Codificar los datos

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
