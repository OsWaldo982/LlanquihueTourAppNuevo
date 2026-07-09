package com.LlanquihueTour.model;

public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(float duracionHoras, String nombre, String tipoEmbarcacion) {
        super(duracionHoras, nombre);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }


    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("   PASEO LACUSTRE");
        System.out.println("   Nombre: " + getNombre());
        System.out.println("   Duración: " + getDuracionHoras() + " horas");
        System.out.println("   Embarcación: " + tipoEmbarcacion);
        System.out.println("   Incluye chaleco salvavidas y guía");
    }


    @Override
    public String toString() {
        return "PASEO LACUSTRE | " + super.toString() +
                " | Embarcación: " + tipoEmbarcacion;
    }

}
