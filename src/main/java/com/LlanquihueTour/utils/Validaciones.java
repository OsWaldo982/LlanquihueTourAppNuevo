package com.LlanquihueTour.utils;

import com.LlanquihueTour.exception.DatoInvalidoException;

/**
 * Libreria propia que concentra las validaciones comunes del proyecto.
 */
public final class Validaciones {

    private Validaciones() {
    }

    public static String textoObligatorio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new DatoInvalidoException(nombreCampo + " es obligatorio.");
        }
        return valor.trim();
    }

    public static int enteroPositivo(int valor, String nombreCampo) {
        if (valor <= 0) {
            throw new DatoInvalidoException(nombreCampo + " debe ser mayor que cero.");
        }
        return valor;
    }

    public static float decimalPositivo(float valor, String nombreCampo) {
        if (valor <= 0) {
            throw new DatoInvalidoException(nombreCampo + " debe ser mayor que cero.");
        }
        return valor;
    }

    public static String telefono(String valor) {
        String telefono = textoObligatorio(valor, "El telefono");
        if (!telefono.matches("\\+?[0-9]{8,15}")) {
            throw new DatoInvalidoException("El telefono solo puede contener entre 8 y 15 digitos.");
        }
        return telefono;
    }

    public static String patente(String valor) {
        String patente = textoObligatorio(valor, "La patente").toUpperCase();
        if (!patente.matches("[A-Z0-9]{6}")) {
            throw new DatoInvalidoException("La patente debe contener 6 letras o numeros.");
        }
        return patente;
    }
}
