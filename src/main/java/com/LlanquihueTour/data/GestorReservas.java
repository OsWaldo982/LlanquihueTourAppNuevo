package com.LlanquihueTour.data;

import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.ReservaTuristica;
import com.LlanquihueTour.model.ServicioTuristico;

import java.util.ArrayList;

/**
 * Gestiona las reservas creadas durante la ejecucion del programa.
 */
public class GestorReservas {

    private final ArrayList<ReservaTuristica> reservas;
    private int siguienteNumero;

    public GestorReservas() {
        reservas = new ArrayList<>();
        siguienteNumero = 1;
    }

    public ReservaTuristica crearReserva(String cliente, ServicioTuristico servicio, GuiaTuristico guia) {
        ReservaTuristica reserva = new ReservaTuristica(siguienteNumero, cliente, servicio, guia);
        reservas.add(reserva);
        siguienteNumero++;
        return reserva;
    }

    public ArrayList<ReservaTuristica> buscarReservas(String criterio) {
        ArrayList<ReservaTuristica> resultados = new ArrayList<>();
        String textoBuscado = criterio == null ? "" : criterio.trim().toLowerCase();

        for (ReservaTuristica reserva : reservas) {
            if (reserva.toString().toLowerCase().contains(textoBuscado)) {
                resultados.add(reserva);
            }
        }
        return resultados;
    }

    public ArrayList<ReservaTuristica> getReservas() {
        return new ArrayList<>(reservas);
    }

    @Override
    public String toString() {
        return "Gestor de reservas | Total: " + reservas.size();
    }
}
