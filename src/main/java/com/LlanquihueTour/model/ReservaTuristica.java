package com.LlanquihueTour.model;

import com.LlanquihueTour.exception.DatoInvalidoException;
import com.LlanquihueTour.utils.Validaciones;

/**
 * Representa una reserva mediante composicion de un servicio y un guia.
 */
public class ReservaTuristica {

    private int numeroReserva;
    private String nombreCliente;
    private ServicioTuristico servicio;
    private GuiaTuristico guia;

    public ReservaTuristica(int numeroReserva, String nombreCliente,
                            ServicioTuristico servicio, GuiaTuristico guia) {
        setNumeroReserva(numeroReserva);
        setNombreCliente(nombreCliente);
        setServicio(servicio);
        setGuia(guia);
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = Validaciones.enteroPositivo(numeroReserva, "El numero de reserva");
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = Validaciones.textoObligatorio(nombreCliente, "El nombre del cliente");
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        if (servicio == null) {
            throw new DatoInvalidoException("El servicio es obligatorio.");
        }
        this.servicio = servicio;
    }

    public GuiaTuristico getGuia() {
        return guia;
    }

    public void setGuia(GuiaTuristico guia) {
        if (guia == null) {
            throw new DatoInvalidoException("El guia es obligatorio.");
        }
        this.guia = guia;
    }

    @Override
    public String toString() {
        return "RESERVA N° " + numeroReserva +
                " | Cliente: " + nombreCliente +
                " | Servicio: " + servicio.getNombre() +
                " | Guia: " + guia.getNombre();
    }
}
