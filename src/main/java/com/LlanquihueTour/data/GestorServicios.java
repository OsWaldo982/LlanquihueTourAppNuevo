package com.LlanquihueTour.data;

import com.LlanquihueTour.model.ServicioTuristico;

import java.util.ArrayList;

/**
 * Carga y entrega los servicios turisticos disponibles.
 */
public class GestorServicios {

    public ArrayList<ServicioTuristico> generarTuristicos() {
        LectorDatos lector = new LectorDatos();
        return lector.cargarServicios("/datos/servicios.txt");
    }

    @Override
    public String toString() {
        return "Gestor de servicios turisticos";
    }
}
