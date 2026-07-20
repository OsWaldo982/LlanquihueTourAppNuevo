package com.LlanquihueTour.model;

import com.LlanquihueTour.utils.Validaciones;

/**
 * Vehiculo disponible para transportar a los pasajeros.
 */
public class Vehiculo implements Registrable {
    private String patente;
    private String tipo;
    private int capacidad;

    public Vehiculo(String patente, String tipo, int capacidad) {
        setPatente(patente);
        setTipo(tipo);
        setCapacidad(capacidad);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = Validaciones.patente(patente);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Validaciones.textoObligatorio(tipo, "El tipo de vehiculo");
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = Validaciones.enteroPositivo(capacidad, "La capacidad");
    }

    @Override
    public void mostrarResumen() {
        System.out.println("VEHÍCULO");
        System.out.println("Patente: " + patente);
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidad: " + capacidad + " pasajeros");
    }

    @Override
    public String toString() {
        return "VEHICULO | Patente: " + patente +
                " | Tipo: " + tipo +
                " | Capacidad: " + capacidad + " pasajeros";
    }
}
