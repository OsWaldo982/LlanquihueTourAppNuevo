package com.LlanquihueTour.model;

import com.LlanquihueTour.utils.Validaciones;

/**
 * Clase base con los datos comunes de los servicios ofrecidos por la agencia.
 */
public abstract class ServicioTuristico {

    private String nombre;
    private float duracionHoras;


    public ServicioTuristico(float duracionHoras, String nombre) {
        setDuracionHoras(duracionHoras);
        setNombre(nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Validaciones.textoObligatorio(nombre, "El nombre del servicio");
    }

    public float getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(float duracionHoras) {
        this.duracionHoras = Validaciones.decimalPositivo(duracionHoras, "La duracion");
    }


    // Este metodo se sobreescribe en cada tipo de servicio.
    public abstract void mostrarInformacion();



    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}
