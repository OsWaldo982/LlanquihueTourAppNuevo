package com.LlanquihueTour.model;

public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;


    public ExcursionCultural(float duracionHoras, String nombre, String lugarHistorico) {
        super(duracionHoras, nombre);
        this.lugarHistorico = lugarHistorico;
    }


    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("   EXCURSIÓN CULTURAL");
        System.out.println("   Nombre: " + getNombre());
        System.out.println("   Duración: " + getDuracionHoras() + " horas");
        System.out.println("   Lugar histórico: " + lugarHistorico);
        System.out.println("   Incluye guía especializado");
    }

    @Override
    public String toString() {
        return "EXCURSION CULTURAL | " + super.toString() +
                " | Lugar histórico: " + lugarHistorico;
    }

}
