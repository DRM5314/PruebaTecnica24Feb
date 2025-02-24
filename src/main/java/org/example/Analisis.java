package org.example;

public class Analisis {
    private int nombre;
    private int repeticiones = 1;
    private String resultado;

    public Analisis(int nombre) {
        this.nombre = nombre;
    }
    public int getNombre() {
        return nombre;
    }
    public int getRepeticiones() {
        return repeticiones;
    }

    public void aumentarRepeticiones() {
        this.repeticiones += 1;
    }

    public void setResultado(String resultdo){
        this.resultado = resultdo;
    }
    public String toString(){
        return "(Valor: "+nombre+" Repeticiones: "+repeticiones+" )";
    }
}
