package com.LlanquihueTour.model;

public class GuiaTuristico implements Registrable {
    private String nombre;
    private String especialidad;
    private int yearsExperiencia;

    public GuiaTuristico(String nombre, String especialidad, int aniosExperiencia) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.yearsExperiencia = aniosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getYearsExperiencia() {
        return yearsExperiencia;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("GUÍA TURÍSTICO");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + yearsExperiencia);
    }
}