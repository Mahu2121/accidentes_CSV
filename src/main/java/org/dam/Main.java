package org.dam;

import org.dam.models.Accidente;
import org.dam.storage.AccidentesStorageCsv;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AccidentesStorageCsv csv = new AccidentesStorageCsv();
        List<Accidente> accidentes = csv.readFromFile(new File("data/2025_Accidentalidad.csv"));

        accidentes.stream().forEach(System.out::println);
        // - Accidentes en los que están implicados alcohol o drogas.
        System.out.println("Accidentes en los que están implicados alcohol o drogas.");
        System.out.println(accidentes.stream().map(Accidente::getPositivoAlcohol).filter(s -> s.equals("S")).count());

        // - Número de accidentes agrupados por sexo.
        System.out.println("Número de accidentes agrupados por sexo.");

        System.out.println("Mujeres:" + accidentes.stream().map(Accidente::getSexo).filter(s -> s.equals("Mujer")).count());
        System.out.println("Hombre:" + accidentes.stream().map(Accidente::getSexo).filter(s -> s.equals("Hombre")).count());

        // - Número de accidentes agrupados por meses.
        System.out.println("Número de accidentes agrupados por meses.");
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        for (int i = 1; i <= 12; i++) {
            final int mes = i;
            System.out.println(meses[i - 1] + ":" + accidentes.stream().filter(accidente -> accidente.getMes(accidente.getFecha() ).equals(mes)).count());
        }

        // - Accidentes dónde haya habido atropellos a personas.
        System.out.println("Accidentes dónde haya habido atropellos a personas.");

        System.out.println(accidentes.stream().map(Accidente::getTipoAccidente).filter(s -> s.equals("Atropello a persona")).count());

    }
}