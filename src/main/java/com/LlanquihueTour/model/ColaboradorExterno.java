package com.LlanquihueTour.model;

import com.LlanquihueTour.utils.Validaciones;

/**
 * Empresa o persona externa que presta un servicio a la agencia.
 */
public class ColaboradorExterno implements Registrable {
    private String nombre;
    private String servicio;
    private String telefono;

    public ColaboradorExterno(String nombre, String servicio, String telefono) {
        setNombre(nombre);
        setServicio(servicio);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre del colaborador");
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = Validaciones.textoObligatorio(servicio, "El servicio");
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = Validaciones.telefono(telefono);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("COLABORADOR EXTERNO");
        System.out.println("Nombre: " + nombre);
        System.out.println("Servicio: " + servicio);
        System.out.println("Teléfono: " + telefono);
    }

    @Override
    public String toString() {
        return "COLABORADOR EXTERNO | Nombre: " + nombre +
                " | Servicio: " + servicio +
                " | Telefono: " + telefono;
    }
}
