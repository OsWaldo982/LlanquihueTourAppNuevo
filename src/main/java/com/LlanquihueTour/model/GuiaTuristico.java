package com.LlanquihueTour.model;

import com.LlanquihueTour.utils.Validaciones;

/**
 * Guia disponible para acompañar las experiencias turisticas.
 */
public class GuiaTuristico implements Registrable {
    private String nombre;
    private String especialidad;
    private int yearsExperiencia;

    public GuiaTuristico(String nombre, String especialidad, int aniosExperiencia) {
        setNombre(nombre);
        setEspecialidad(especialidad);
        setYearsExperiencia(aniosExperiencia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre del guia");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = Validaciones.textoObligatorio(especialidad, "La especialidad");
    }

    public int getYearsExperiencia() {
        return yearsExperiencia;
    }

    public void setYearsExperiencia(int yearsExperiencia) {
        this.yearsExperiencia = Validaciones.enteroPositivo(yearsExperiencia, "Los años de experiencia");
    }

    @Override
    public void mostrarResumen() {
        System.out.println("GUÍA TURÍSTICO");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + yearsExperiencia);
    }

    @Override
    public String toString() {
        return "GUIA TURISTICO | Nombre: " + nombre +
                " | Especialidad: " + especialidad +
                " | Experiencia: " + yearsExperiencia + " años";
    }
}
