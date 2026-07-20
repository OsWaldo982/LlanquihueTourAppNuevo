package com.LlanquihueTour.utils;

import com.LlanquihueTour.exception.DatoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidacionesTest {

    @Test
    void normalizaUnaPatenteValida() {
        assertEquals("ABCD12", Validaciones.patente("abcd12"));
    }

    @Test
    void rechazaUnTelefonoInvalidoConExcepcionPersonalizada() {
        assertThrows(DatoInvalidoException.class,
                () -> Validaciones.telefono("telefono incorrecto"));
    }
}
