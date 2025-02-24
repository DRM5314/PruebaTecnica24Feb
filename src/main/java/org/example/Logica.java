package org.example;
import java.util.*;
public class Logica {
    protected void analizar(List<Entidad> listado) {
        for (Entidad entidad : listado) {
            System.out.println("En: "+entidad.getAnalisis());
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
                if (!bandera)
                    entidadesAnalisis.add(analisisAux);
            }
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

            int analisis_1 = valor1.getRepeticiones() - valor2.getRepeticiones();
            int analisis_2 = valor2.getRepeticiones() - valor3.getRepeticiones();
            if (analisis_1 == 0 && analisis_2 == 0) {
                return "No existe moda ";
            }else if (analisis_1 == 0) {
                return "Bimodal, valores: " + "Moda 1: "+valor1.toString()+" Moda 2: "+valor2.toString();
            } else if (valor1.getRepeticiones() > valor2.getRepeticiones()) {
                return "Moda: " + valor1.toString();
            }
        }else {
            return ("No hay datos para analizar");
        }
        return "Sin datos";
    }
}
