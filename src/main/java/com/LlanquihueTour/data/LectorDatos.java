package com.LlanquihueTour.data;

import com.LlanquihueTour.exception.DatoInvalidoException;
import com.LlanquihueTour.model.ColaboradorExterno;
import com.LlanquihueTour.model.ExcursionCultural;
import com.LlanquihueTour.model.GuiaTuristico;
import com.LlanquihueTour.model.PaseoLacustre;
import com.LlanquihueTour.model.Registrable;
import com.LlanquihueTour.model.RutaGastronomica;
import com.LlanquihueTour.model.ServicioTuristico;
import com.LlanquihueTour.model.Vehiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Lee los archivos TXT del proyecto y convierte cada fila en un objeto.
 */
public class LectorDatos {

    public ArrayList<Registrable> cargarEntidades(String rutaArchivo) {
        ArrayList<Registrable> entidades = new ArrayList<>();

        try (BufferedReader lector = abrirArchivo(rutaArchivo)) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                    continue;
                }

                String[] datos = linea.split(";", -1);
                try {
                    entidades.add(crearEntidad(datos));
                } catch (RuntimeException e) {
                    throw new DatoInvalidoException(
                            "Error en " + rutaArchivo + ", linea " + numeroLinea + ": " + e.getMessage(), e);
                }
            }
        } catch (IOException e) {
            throw new DatoInvalidoException("No fue posible leer " + rutaArchivo, e);
        }

        return entidades;
    }

    public ArrayList<ServicioTuristico> cargarServicios(String rutaArchivo) {
        ArrayList<ServicioTuristico> servicios = new ArrayList<>();

        try (BufferedReader lector = abrirArchivo(rutaArchivo)) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                    continue;
                }

                String[] datos = linea.split(";", -1);
                try {
                    servicios.add(crearServicio(datos));
                } catch (RuntimeException e) {
                    throw new DatoInvalidoException(
                            "Error en " + rutaArchivo + ", linea " + numeroLinea + ": " + e.getMessage(), e);
                }
            }
        } catch (IOException e) {
            throw new DatoInvalidoException("No fue posible leer " + rutaArchivo, e);
        }

        return servicios;
    }

    private BufferedReader abrirArchivo(String rutaArchivo) {
        InputStream archivo = LectorDatos.class.getResourceAsStream(rutaArchivo);
        if (archivo == null) {
            throw new DatoInvalidoException("No se encontro el archivo " + rutaArchivo);
        }
        return new BufferedReader(new InputStreamReader(archivo, StandardCharsets.UTF_8));
    }

    private Registrable crearEntidad(String[] datos) {
        if (datos.length != 4) {
            throw new DatoInvalidoException("La entidad debe tener 4 datos separados por punto y coma.");
        }

        if (datos[0].equalsIgnoreCase("GUIA")) {
            return new GuiaTuristico(datos[1], datos[2], Integer.parseInt(datos[3]));
        } else if (datos[0].equalsIgnoreCase("VEHICULO")) {
            return new Vehiculo(datos[1], datos[2], Integer.parseInt(datos[3]));
        } else if (datos[0].equalsIgnoreCase("COLABORADOR")) {
            return new ColaboradorExterno(datos[1], datos[2], datos[3]);
        }

        throw new DatoInvalidoException("Tipo de entidad desconocido: " + datos[0]);
    }

    private ServicioTuristico crearServicio(String[] datos) {
        if (datos.length != 4) {
            throw new DatoInvalidoException("El servicio debe tener 4 datos separados por punto y coma.");
        }

        float duracion = Float.parseFloat(datos[1]);
        if (datos[0].equalsIgnoreCase("GASTRONOMICA")) {
            return new RutaGastronomica(duracion, datos[2], Integer.parseInt(datos[3]));
        } else if (datos[0].equalsIgnoreCase("LACUSTRE")) {
            return new PaseoLacustre(duracion, datos[2], datos[3]);
        } else if (datos[0].equalsIgnoreCase("CULTURAL")) {
            return new ExcursionCultural(duracion, datos[2], datos[3]);
        }

        throw new DatoInvalidoException("Tipo de servicio desconocido: " + datos[0]);
    }

    @Override
    public String toString() {
        return "Lector de archivos TXT de Llanquihue Tour";
    }
}
