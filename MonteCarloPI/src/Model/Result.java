package model;

public class Resultado {

    private final int ejecuciones;
    private final int nodos;
    private double epsilon;

    private double totalPi = 0;
    private double totalTiempo = 0;

    private String output = "";

    public Resultado(int id, int seed, long puntos, int ejecuciones, int nodos) {
        this.ejecuciones = ejecuciones;
        this.nodos = nodos;

        output += "Test: " + id + "\n";
        output += "Seed: " + seed + ", " + "Puntos: " + puntos + "\n";
        output += "Valor epsilon: " + epsilon + "\n";
        output += "Valor Pi" + ", " + "Tiempo de ejecucion\n";
    }

    public void agregarIteracion(double valorPi, double tiempoEjec) {
        totalPi += valorPi;
        totalTiempo += tiempoEjec;
        output += valorPi + ", " + tiempoEjec + "\n";
    }

    public String terminarTest() {
        double promedioPi = totalPi / ejecuciones;
        double promedioTiempo = totalTiempo / ejecuciones;
        output += "Promedio Pi" + ", " + promedioPi + "\n";
        output += "Promedio Tiempo" + ", " + promedioTiempo + "ms\n";
        output += "Nodos" + ", " + nodos + "\n\n";
        return output;
    }
}
