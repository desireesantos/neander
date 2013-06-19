package io;

import components.Memory;
import java.io.*;

import static components.Memory.MEMORY_SIZE;

/**
 * User: dsantos
 * Date: 6/6/13  - Time: 4:45 PM
 */
public class Reader {
    private String pathFile;
    private FileInputStream file;
    private BufferedReader bufferedReader;
    private String[] memory;

    public Reader(String pathFile) throws IOException {
        this.pathFile = pathFile;
        try {
            this.file = new FileInputStream(this.pathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(new InputStreamReader(file));
        createUnitMemory();
    }

    public String getPathFile() {
        return pathFile;
    }

    public String[] getMemory() {
        return memory;
    }

    private void createUnitMemory() throws IOException {
        String[] memory = new String[MEMORY_SIZE];
        String line;
        int counter = 0;
        while (((line = bufferedReader.readLine()) != null) && counter < MEMORY_SIZE) {
            memory[counter] = line;
            counter++;
        }
        bufferedReader.close();
        this.memory = memory;
    }
}
