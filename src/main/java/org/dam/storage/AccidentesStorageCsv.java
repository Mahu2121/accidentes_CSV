package org.dam.storage;

import org.dam.models.Accidente;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

public class AccidentesStorageCsv implements AccidentesStorage{

    @Override
    public List<Accidente> readFromFile(File file) {
        try {
            return Files.readAllLines(file.toPath())
                    .stream()
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(this::trimArray)
                    .map(this::createAccidenteReport)
                    .toList();
        } catch(Exception e) {
            System.out.println(e);
        }
        return List.of();
    }

    private String[] trimArray(String[] array) {
        return Stream.of(array).map(String::trim).toArray(String[]::new);
    }

    private Double parseDoubleOrNull(String s) {
        if (s == null || s.isEmpty()) return null;
        try {
            return Double.valueOf(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Accidente createAccidenteReport(String[] data) {
        return new Accidente(
                data.length > 0 ? data[0] : "",
                data.length > 1 ? data[1] : "",
                data.length > 2 ? data[2] : "",
                data.length > 3 ? data[3] : "",
                parseDoubleOrNull(data.length > 4 ? data[4] : null),
                parseDoubleOrNull(data.length > 5 ? data[5] : null),
                data.length > 6 ? data[6] : "",
                data.length > 7 ? data[7] : "",
                data.length > 8 ? data[8] : "",
                data.length > 9 ? data[9] : "",
                data.length > 10 ? data[10] : "",
                data.length > 11 ? data[11] : "",
                data.length > 12 ? data[12] : "",
                parseDoubleOrNull(data.length > 13 ? data[13] : null),
                data.length > 14 ? data[14] : "",
                parseDoubleOrNull(data.length > 15 ? data[15] : null),
                parseDoubleOrNull(data.length > 16 ? data[16] : null),
                data.length > 17 ? data[17] : ""
        );
    }

    @Override
    public void writeToFile(File file, List<Accidente> accidentes) {
        try {
            StringBuilder content = new StringBuilder();
            content.append("numExpediente;fecha;hora;localizacion;numero;codigoDistrito;distrito;tipoAccidente;estadoMeteorologico;tipoVehiculo;tipoPersona;rangoEdad;sexo;codLesividad;lesividad;coordenadaX;coordenadaY;positivoAlcohol\n");

            for (Accidente accidente : accidentes) {
                content.append(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                        accidente.getNumExpediente(),
                        accidente.getFecha(),
                        accidente.getHora(),
                        accidente.getLocalizacion(),
                        accidente.getNumero() != null ? accidente.getNumero() : "",
                        accidente.getCodigoDistrito() != null ? accidente.getCodigoDistrito() : "",
                        accidente.getDistrito(),
                        accidente.getTipoAccidente(),
                        accidente.getEstadoMeteorologico(),
                        accidente.getTipoVehiculo(),
                        accidente.getTipoPersona(),
                        accidente.getRangoEdad(),
                        accidente.getSexo(),
                        accidente.getCodLesividad() != null ? accidente.getCodLesividad() : "",
                        accidente.getLesividad(),
                        accidente.getCoordenadaX() != null ? accidente.getCoordenadaX() : "",
                        accidente.getCoordenadaY() != null ? accidente.getCoordenadaY() : "",
                        accidente.getPositivoAlcohol()
                ));
            }
            Files.writeString(file.toPath(), content.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}





