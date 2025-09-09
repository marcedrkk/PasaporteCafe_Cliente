package com.andres.pasaportecafeovalle.ui.activity.ui.modelo;

public class Sucursal {

    private int imagen;
    private String nombre;
    private String direccion;

    private double lat;
    private double lot;

    private String horario;

    private String estado;

    public Sucursal(int imagen, String nombre, String direccion, double lat, double lot, String horario, String estado) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.lat = lat;
        this.lot = lot;
        this.horario = horario;
        this.estado = estado;
    }

    public Sucursal(int imagen, String nombre, String direccion, String horario, String estado) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.estado = estado;
    }



    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getLat() {
        return lat;
    }

    public double getLot() {
        return lot;
    }

    public String getHorario() {
        return horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLot(double lot) {
        this.lot = lot;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
