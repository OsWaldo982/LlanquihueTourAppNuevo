package com.LlanquihueTour.model;

public class ServicioTuristico {

    private String nombre;
    private float duracionHoras;


    public ServicioTuristico(float duracionHoras, String nombre) {
        this.duracionHoras = duracionHoras;
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }


    // este metodo se va a sobreescribir
    public void mostrarInformacion() {
        System.out.println("Servicio: " + nombre + " | Duración: " + duracionHoras + " horas");
    }



    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}
