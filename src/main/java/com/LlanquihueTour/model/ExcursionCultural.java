package com.LlanquihueTour.model;

import com.LlanquihueTour.utils.Validaciones;

/**
 * Servicio turistico enfocado en un lugar historico o patrimonial.
 */
public class ExcursionCultural extends ServicioTuristico  {

    private String lugarHistorico;


    public ExcursionCultural(float duracionHoras, String nombre, String lugarHistorico) {
        super(duracionHoras, nombre);
        setLugarHistorico(lugarHistorico);
    }


    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = Validaciones.textoObligatorio(lugarHistorico, "El lugar historico");
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
