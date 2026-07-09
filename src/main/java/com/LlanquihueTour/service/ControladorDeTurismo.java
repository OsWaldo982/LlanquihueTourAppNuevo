package com.LlanquihueTour.service;

import com.LlanquihueTour.model.ExcursionCultural;
import com.LlanquihueTour.model.PaseoLacustre;
import com.LlanquihueTour.model.RutaGastronomica;
import com.LlanquihueTour.model.ServicioTuristico;

import java.util.ArrayList;

public class ControladorDeTurismo {


    public void mostrarTuristicos(ArrayList<ServicioTuristico> turisticos) {

        System.out.println("=== SERVICIOS TURÍSTICOS ===");

        for (ServicioTuristico turistico : turisticos) {

            System.out.println("-------------------------");

            if (turistico instanceof ExcursionCultural) {

                ExcursionCultural cultural = (ExcursionCultural) turistico;

                System.out.println("EXCURSIÓN CULTURAL");
                System.out.println("Lugar histórico: " + cultural.getLugarHistorico());

            } else if (turistico instanceof RutaGastronomica) {
                RutaGastronomica ruta = (RutaGastronomica) turistico;
                System.out.println("RUTA GASTRONÓMICA");
                System.out.println("Paradas: " + ruta.getNumeroDeParadas());

            } else if (turistico instanceof PaseoLacustre) {
                PaseoLacustre paseo = (PaseoLacustre) turistico;
                System.out.println("PASEO LACUSTRE");
                System.out.println("Embarcación: " + paseo.getTipoEmbarcacion());
            }

            turistico.mostrarInformacion();
        }
    }

}

