package com.LlanquihueTour.model;

public class Vehiculo implements Registrable {
    private String patente;
    private String tipo;
    private int capacidad;

    public Vehiculo(String patente, String tipo, int capacidad) {
        this.patente = patente;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public String getPatente() {
        return patente;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("VEHÍCULO");
        System.out.println("Patente: " + patente);
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidad: " + capacidad + " pasajeros");
    }
}