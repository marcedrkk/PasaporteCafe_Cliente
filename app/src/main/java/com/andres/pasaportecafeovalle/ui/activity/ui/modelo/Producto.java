package com.andres.pasaportecafeovalle.ui.activity.ui.modelo;

public class Producto {

    private int image;
    private String nombre;
    private String categoria;
    private float precio;

    private String estado;

    public Producto(int image, String nombre, String categoria, float precio, String estado) {
        this.image = image;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(int image, String nombre, float precio) {
        this.image = image;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImage() {
        return image;
    }
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }
}
