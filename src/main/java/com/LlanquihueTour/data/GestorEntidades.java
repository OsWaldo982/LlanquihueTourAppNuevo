package com.LlanquihueTour.data;

import com.LlanquihueTour.model.Registrable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona la coleccion polimorfica de guias, vehiculos y colaboradores.
 */
public class GestorEntidades {

    private final ArrayList<Registrable> entidades;

    public GestorEntidades() {
        LectorDatos lector = new LectorDatos();
        entidades = lector.cargarEntidades("/datos/entidades.txt");
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public ArrayList<Registrable> buscarEntidades(String criterio) {
        ArrayList<Registrable> resultados = new ArrayList<>();
        String textoBuscado = criterio == null ? "" : criterio.trim().toLowerCase();

        for (Registrable entidad : entidades) {
            if (entidad.toString().toLowerCase().contains(textoBuscado)) {
                resultados.add(entidad);
            }
        }
        return resultados;
    }

    // Sobrecarga: permite filtrar la misma coleccion por tipo de clase.
    public ArrayList<Registrable> buscarEntidades(Class<?> tipoEntidad) {
        ArrayList<Registrable> resultados = new ArrayList<>();
        for (Registrable entidad : entidades) {
            if (tipoEntidad.isInstance(entidad)) {
                resultados.add(entidad);
            }
        }
        return resultados;
    }

    public boolean eliminarEntidad(String criterio) {
        String textoBuscado = criterio == null ? "" : criterio.trim().toLowerCase();
        Iterator<Registrable> iterador = entidades.iterator();

        while (iterador.hasNext()) {
            Registrable entidad = iterador.next();
            if (!textoBuscado.isEmpty() && entidad.toString().toLowerCase().contains(textoBuscado)) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Registrable> getEntidades() {
        return new ArrayList<>(entidades);
    }

    @Override
    public String toString() {
        return "Gestor de entidades | Total: " + entidades.size();
    }
}
