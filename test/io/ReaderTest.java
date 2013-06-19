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
        file = new Reader("file/enander.txt");
        Assert.assertTrue(file.getPathFile().endsWith("file/enander.txt"));
    }

    @Test
    public void differentsFile() throws IOException{
        file = new Reader("file/enander.txt");
        fileTest = new Reader("file/enanderTest.txt");
        Assert.assertFalse(file.equals(fileTest));
    }

    @Test
    public void readFirstLineInFile() throws IOException {
        file = new Reader("file/enander.txt");
        String[] memory = file.getMemory();
        Assert.assertThat(memory[0], equalTo("00100000"));
    }

    @Test
    public void readSecondLineInFile() throws IOException {
        file = new Reader("file/enander.txt");
        String[] memory = file.getMemory();
        Assert.assertThat(memory[1], equalTo("00001000"));
    }

}
