package com.LlanquihueTour.service;

import com.LlanquihueTour.model.ExcursionCultural;
import com.LlanquihueTour.model.PaseoLacustre;
import com.LlanquihueTour.model.RutaGastronomica;
import com.LlanquihueTour.model.ServicioTuristico;

import java.util.ArrayList;

/**
 * Prepara la informacion de servicios para la consola o la interfaz grafica.
 */
public class ControladorDeTurismo {

    public void mostrarTuristicos(ArrayList<ServicioTuristico> turisticos) {
        System.out.print(obtenerResumenTuristicos(turisticos));
    }

    public String obtenerResumenTuristicos(ArrayList<ServicioTuristico> turisticos) {
        StringBuilder resumen = new StringBuilder("=== SERVICIOS TURISTICOS ===\n\n");

        for (ServicioTuristico turistico : turisticos) {
            if (turistico instanceof ExcursionCultural) {
                resumen.append("EXCURSION CULTURAL\n");
            } else if (turistico instanceof RutaGastronomica) {
                resumen.append("RUTA GASTRONOMICA\n");
            } else if (turistico instanceof PaseoLacustre) {
                resumen.append("PASEO LACUSTRE\n");
            }
            resumen.append("  ").append(turistico).append("\n");
            resumen.append("----------------------------------------\n");
        }
        return resumen.toString();
    }

    @Override
    public String toString() {
        return "Controlador de servicios turisticos";
    }
}
