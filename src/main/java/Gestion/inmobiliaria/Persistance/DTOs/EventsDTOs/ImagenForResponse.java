package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Imagen;

import java.util.Base64;

public class ImagenForResponse {
    private Long id;
    private String tipo;
    private double tamaño;
    private String ruta; // Ahora solo guardamos la ruta

    public ImagenForResponse(Imagen imagen) {
        this.id = imagen.getId();
        this.tipo = imagen.getTipo();
        this.tamaño = imagen.getTamaño();
        this.ruta = imagen.getRuta(); // Solo devolvemos la ruta
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
