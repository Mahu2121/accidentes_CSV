package org.dam.storage;

import org.dam.models.Accidente;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccidentesStorageCsv implements AccidentesStorage{

    @Override
    public List<Accidente> readFromFile(File file)  {
        try {
            return Files.readAllLines(file.toPath())
                    .stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(this::trimArray)
                    .map(this::createAccidenteReport)
                    .toList();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return List.of();
    }

    private String[] trimArray(String[] array) {
        return Stream.of(array).map(String::trim).toArray(String[]::new);
    }

    private Accidente createAccidenteReport(String[] data) {
        return new Accidente(
                data[0],
                Integer.parseInt(data[1]),
                data[2],
                data[3],
                Integer.parseInt(data[4]),
                Integer.parseInt(data[5]),
                data[6],
                data[7],
                data[8],
                data[9],
                data[10],
                data[11],
                data[12],
                Integer.parseInt(data[13]),
                data[14],
                Integer.parseInt(data[15]),
                Integer.parseInt(data[16]),
                data[17]
        );
    }
    @Override
    public void writeToFile(File file, List<Accidente> accidentes) {
        try {
            StringBuilder content = new StringBuilder();
            content.append("numExpediente,fecha,hora,localizacion,numero,codigoDistrito,distrito,tipoAccidente,estadoMeteorologico,tipoVehiculo,tipoPersona,rangoEdad,sexo,codLesividad,lesividad,coordenadaX,coordenadaY,positivoAlcohol\n");

            for (Accidente accidente : accidentes) {
                content.append(String.format("%d,%s,%s,%s,%d,%d,%s,%s,%s,%s,%s,%s,%s,%d,%s,%d,%d,%s\n",
                        accidente.getNumExpediente(),
                        accidente.getFecha(),
                        accidente.getHora(),
                        accidente.getLocalizacion(),
                        accidente.getNumero(),
                        accidente.getCodigoDistrito(),
                        accidente.getDistrito(),
                        accidente.getTipoAccidente(),
                        accidente.getEstadoMeteorologico(),
                        accidente.getTipoVehiculo(),
                        accidente.getTipoPersona(),
                        accidente.getRangoEdad(),
                        accidente.getSexo(),
                        accidente.getCodLesividad(),
                        accidente.getLesividad(),
                        accidente.getCoordenadaX(),
                        accidente.getCoordenadaY(),
                        accidente.getPositivoAlcohol()
                ));
            }
            Files.writeString(file.toPath(), content.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}





