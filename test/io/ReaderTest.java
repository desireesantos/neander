package io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: dsantos
 * Date: 6/6/13  - Time: 4:46 PM
 */
public class ReaderTest {

    Reader file, fileTest;

    @Test
    public void thereIsFileInThisPath() throws IOException {
        file = new Reader("/Users/dsantos/Desktop/enander/enander.txt");
        Assert.assertTrue(file.getPathFile().endsWith("enander.txt"));
    }

    @Test
    public void differentsFile() throws IOException{
        file = new Reader("/Users/dsantos/Desktop/enander/enander.txt");
        fileTest = new Reader("/Users/dsantos/Desktop/enander/enanderTest.txt");
        Assert.assertFalse(file.equals(fileTest));
    }

    @Test
    public void readFirstLineInFile() throws IOException {
        file = new Reader("/Users/dsantos/Desktop/enander/enander.txt");
        String[] memory = file.getMemory();
        Assert.assertThat(memory[1], equalTo("00001000"));
    }

    @Test
    public void readSecondLineInFile() throws IOException {
        file = new Reader("/Users/dsantos/Desktop/enander/enander.txt");
        String[] memory = file.getMemory();
        Assert.assertThat(memory[7], equalTo("11110000"));
    }
}
