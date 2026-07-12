package com.LlanquihueTour.data;


import com.LlanquihueTour.model.ColaboradorExterno;
import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.Registrable;
import com.LlanquihueTour.model.Vehiculo;

import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
        cargarEntidades();
    }

    private void cargarEntidades() {
        entidades.add(new GuiaTuristico("Pedro Muñoz", "Montaña", 8));
        entidades.add(new GuiaTuristico("Laura Vidal", "Gastronomía", 5));
        entidades.add(new Vehiculo("ABCD12", "Van", 12));
        entidades.add(new Vehiculo("EFGH34", "Bus", 30));
        entidades.add(new ColaboradorExterno("Restaurante El Patagónico", "Alimentación", "+56912345678"));
        entidades.add(new ColaboradorExterno("Museo Colonial", "Cultura", "+56987654321"));
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }


    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }
}