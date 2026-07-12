package com.LlanquihueTour.model;

public class ColaboradorExterno implements Registrable {
    private String nombre;
    private String servicio;
    private String telefono;

    public ColaboradorExterno(String nombre, String servicio, String telefono) {
        this.nombre = nombre;
        this.servicio = servicio;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("COLABORADOR EXTERNO");
        System.out.println("Nombre: " + nombre);
        System.out.println("Servicio: " + servicio);
        System.out.println("Teléfono: " + telefono);
    }
}