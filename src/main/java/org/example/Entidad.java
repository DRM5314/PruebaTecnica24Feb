package org.example;

public class Entidad {
    /*
    Clase valor que solo tiene numeros,
    pero mas adelante se puede agregar mas
    atributos a la clase hacer un analisis mas completo
    */
    private String analisis;
    private int [] valores;
    public Entidad(String analisis, int [] valores) {
        this.analisis = analisis;
        this.valores = valores;
    }
    public String getAnalisis() {
        return analisis;
    }
    public int [] getValores() {
        return valores;
    }
}
