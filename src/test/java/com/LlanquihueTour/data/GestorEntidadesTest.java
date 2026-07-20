package com.LlanquihueTour.data;

import com.LlanquihueTour.model.GuiaTuristico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestorEntidadesTest {

    @Test
    void permiteAgregarBuscarFiltrarYEliminar() {
        GestorEntidades gestor = new GestorEntidades();
        gestor.agregarEntidad(new GuiaTuristico("Ana Soto", "Historia", 3));

        assertEquals(7, gestor.getEntidades().size());
        assertEquals(1, gestor.buscarEntidades("Ana Soto").size());
        assertEquals(3, gestor.buscarEntidades(GuiaTuristico.class).size());
        assertTrue(gestor.eliminarEntidad("Ana Soto"));
        assertFalse(gestor.eliminarEntidad("No existe"));
        assertEquals(6, gestor.getEntidades().size());
    }
}
