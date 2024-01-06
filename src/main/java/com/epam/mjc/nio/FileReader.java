package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String input = null;
        try (InputStream inputStream = Files.newInputStream(Path.of(file.getPath()))) {
            input = new String(inputStream.readAllBytes());


            String[] values = new String[4];
            String[] lines = input.split("\r\n");
            int i = 0;
            for (String line : lines) {
                int index = line.indexOf(':');
                values[i++] = line.substring(index + 1).trim();
            }

            return new Profile(values[0], Integer.valueOf(values[1]), values[2], Long.valueOf(values[3]));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
