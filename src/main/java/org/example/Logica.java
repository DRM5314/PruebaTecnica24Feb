package org.example;
import java.util.*;
public class Logica {
    protected void analizar(List<Entidad> listado) {
        //Se puede pasar un numero de analisis cualquiera, este sera recorrido en el orden y indicando el nombre de ese analisis
        for (Entidad entidad : listado) {
            System.out.println("En: "+entidad.getAnalisis());
            //Creamos un listado que nos ayudara a realizar el analisis
            List<Analisis> entidadesAnalisis = new ArrayList<>();
            Entidad entidadAux = entidad;

            for (Integer valor: entidadAux.getValores()) {
                Analisis analisisAux = new Analisis(valor);

                boolean bandera = false;

                for (int i = 0; i < entidadesAnalisis.size(); i++) {
                    Analisis analisis = entidadesAnalisis.get(i);
                    if (analisis.getNombre() == valor){
                        analisis.aumentarRepeticiones();
                        bandera = true;
                        break;
                    }
                }
                //Si nunca encontro el valor en la lista de analisis, lo agrega
                if (!bandera)
                    entidadesAnalisis.add(analisisAux);
            }
            //Ordenamos la lista de analisis, esto quiere decir ordenar los valores de repeticion
            entidadesAnalisis.sort(Comparator.comparing(Analisis::getRepeticiones).reversed());
            String resultado = this.obtenerResultado(entidadesAnalisis);
            System.out.println("Resultado: "+resultado);
        }
    }


    private String obtenerResultado(List<Analisis> entidadesAnalisis){
        if (entidadesAnalisis.size() > 0){
            Analisis valor1 = entidadesAnalisis.get(0);
            Analisis valor2 = entidadesAnalisis.get(1);
            Analisis valor3 = entidadesAnalisis.get(2);

            //Restamos las repeticiones para hacer el analisis
            int analisis_1 = valor1.getRepeticiones() - valor2.getRepeticiones();
            int analisis_2 = valor2.getRepeticiones() - valor3.getRepeticiones();
            //Si el la resta de las repeticiones es 0, quiere decir que no hay moda
            if (analisis_1 == 0 && analisis_2 == 0) {
                return "No existe moda ";
                //Si la resta de las repeticiones es 0, quiere decir que hay dos modas
            }else if (analisis_1 == 0) {
                return "Bimodal, valores: " + "Moda 1: "+valor1.toString()+" Moda 2: "+valor2.toString();
                //Si el primer valor es mayor que el segundo quiere decir que es unimodal
            } else if (valor1.getRepeticiones() > valor2.getRepeticiones()) {
                return "Unimodral: " + valor1.toString();
            }
        }else {
            return ("No hay datos para analizar");
        }
        return "Sin datos";
    }
}
