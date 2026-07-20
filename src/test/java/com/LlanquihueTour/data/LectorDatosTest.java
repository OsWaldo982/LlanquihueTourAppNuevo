package com.LlanquihueTour.data;

import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.Registrable;
import com.LlanquihueTour.model.ServicioTuristico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LectorDatosTest {

    @Test
    void cargaEntidadesDesdeArchivoTxt() {
        LectorDatos lector = new LectorDatos();
        ArrayList<Registrable> entidades = lector.cargarEntidades("/datos/entidades.txt");

        assertEquals(6, entidades.size());
        assertInstanceOf(GuiaTuristico.class, entidades.get(0));
    }

    @Test
    void cargaServiciosDesdeArchivoTxt() {
        LectorDatos lector = new LectorDatos();
        ArrayList<ServicioTuristico> servicios = lector.cargarServicios("/datos/servicios.txt");

        assertEquals(6, servicios.size());
        assertEquals("Sabores del Sur", servicios.get(0).getNombre());
    }
}
