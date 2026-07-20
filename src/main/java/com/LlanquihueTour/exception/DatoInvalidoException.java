package com.LlanquihueTour.exception;

/**
 * Excepcion usada cuando un dato del sistema no cumple las reglas esperadas.
 */
public class DatoInvalidoException extends IllegalArgumentException {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public DatoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    @Override
    public String toString() {
        return "Dato invalido: " + getMessage();
    }
}
