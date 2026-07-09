package com.LlanquihueTour.model;


public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;


    public RutaGastronomica(float duracionHoras, String nombre, int numeroDeParadas) {
        super(duracionHoras, nombre);
        this.numeroDeParadas = numeroDeParadas;

    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("   RUTA GASTRONÓMICA");
        System.out.println("   Nombre: " + getNombre());
        System.out.println("   Duración: " + getDuracionHoras() + " horas");
        System.out.println("   Número de paradas: " + numeroDeParadas);
        System.out.println("   Incluye degustaciones en cada parada");
    }

    @Override
    public String toString() {
        return "RUTA GASTRONÓMICA | " + super.toString() +
                " | Número de paradas: " + numeroDeParadas;
    }
}
