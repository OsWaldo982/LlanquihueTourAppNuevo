package com.LlanquihueTour.ui;


import com.LlanquihueTour.data.GestorServicios;
import com.LlanquihueTour.model.ServicioTuristico;
import com.LlanquihueTour.service.ControladorDeTurismo;

import java.util.ArrayList;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        GestorServicios gestorServicios = new GestorServicios();
        ControladorDeTurismo controladorDeTurismo = new ControladorDeTurismo();

        ArrayList<ServicioTuristico> serviciosTuristicos = gestorServicios.generarTuristicos();

        controladorDeTurismo.mostrarTuristicos(serviciosTuristicos);
    }
}