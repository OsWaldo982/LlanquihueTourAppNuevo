package com.LlanquihueTour.data;

import com.LlanquihueTour.exception.DatoInvalidoException;
import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.ReservaTuristica;
import com.LlanquihueTour.model.RutaGastronomica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GestorReservasTest {

    @Test
    void creaReservaUsandoComposicion() {
        GestorReservas gestor = new GestorReservas();
        GuiaTuristico guia = new GuiaTuristico("Pedro Muñoz", "Montaña", 8);
        RutaGastronomica servicio = new RutaGastronomica(3.5f, "Sabores del Sur", 5);

        ReservaTuristica reserva = gestor.crearReserva("Camila Rojas", servicio, guia);

        assertEquals(1, reserva.getNumeroReserva());
        assertEquals(servicio, reserva.getServicio());
        assertEquals(guia, reserva.getGuia());
        assertEquals(1, gestor.buscarReservas("Camila").size());
    }

    @Test
    void rechazaReservaSinNombreDeCliente() {
        GestorReservas gestor = new GestorReservas();
        GuiaTuristico guia = new GuiaTuristico("Pedro Muñoz", "Montaña", 8);
        RutaGastronomica servicio = new RutaGastronomica(3.5f, "Sabores del Sur", 5);

        assertThrows(DatoInvalidoException.class,
                () -> gestor.crearReserva("", servicio, guia));
    }
}
