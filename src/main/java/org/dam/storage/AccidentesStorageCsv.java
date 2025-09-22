package org.dam.storage;

import org.dam.models.Accidente;

import java.io.File;
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
}




