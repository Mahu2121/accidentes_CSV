package org.dam.storage;

import org.dam.models.Accidente;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class AccidentesStorageCsv implements AccidentesStorage{

    @Override
    public List<Accidente> readFromFile(File file)  {
        try {
            return Files.readAllLines(file.toPath())

        }

        catch(Exception e) {
            System.err.println(e);
        }

    }


    @Override
    public void writeToFile(File file, List<Accidente> productos) {}
}
