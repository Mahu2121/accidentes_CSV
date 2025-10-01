package org.dam.storage;

import org.dam.models.Accidente;

import java.io.File;
import java.util.List;

public interface AccidentesStorage {
    List<Accidente> readFromFile(File file);

}
