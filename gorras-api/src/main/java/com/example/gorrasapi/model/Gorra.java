package com.example.gorrasapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Gorra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String nombre;

    private String color;
    private double precio;

    @Column(nullable = false)
    private int cantidad; // Nuevo campo para el cantidad de la gorra
    private String imagenUrl; // Nuevo campo para la URL de la imagen de la gorra

    // Constructor vacío para JPA
    public Gorra() {
    }
    
    // Constructor
    public Gorra(String nombre, String color, double precio, int cantidad, String imagenUrl) {
        this.nombre = nombre;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagenUrl = imagenUrl;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
