package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List <Entidad> listado = new ArrayList<>();
        //primer arreglo para primer prueba de analisis moda = 5
        int [] valores = {1,2,3,4,5,5,5,5};
        //segundo arreglo para segunda prueba de analisis moda = 5 y 4
        int [] valores2 = {1,2,3,4,4,5,5};
        //tercer arreglo para tercera prueba de analisis moda = 5, 4 y 3
        int [] valores3 = {1,2,3,3,4,4,5,5};

        listado.add(new Entidad("Analisis 1",valores));
        listado.add(new Entidad("Analisis 2",valores2));
        listado.add(new Entidad("Analisis 3",valores3));

        //Llamando a clase logica
        Logica logica = new Logica();
        logica.analizar(listado);

    }
}