package com.epam.mjc.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String input;
        try {
            input = Files.readString(Path.of(file.getPath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String[] values = new String[4];
        String[] lines = input.split("\r\n");
        int i = 0;
        for (String line : lines) {
            int index = line.indexOf(':');
            values[i++] = line.substring(index + 1).trim();
        }

        return new Profile(values[0], Integer.valueOf(values[1]), values[2], Long.valueOf(values[3]));
    }
}
