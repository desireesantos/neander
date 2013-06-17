package control;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import exception.WrongPositionMemoryException;
import factory.MemoryFactory;
import io.Reader;
import processor.Processor;

import java.io.IOException;

/**
 * User: dsantos
 * Date: 6/16/13  - Time: 2:39 AM
 */
public class StartProcessNeander {

    private Reader reader;
    private Memory memory = new Memory();

    public StartProcessNeander(String path)  {
        try {
            reader = new Reader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        initMemory();
        callProcessor();
    }

    private void callProcessor() {
        Processor processor = new Processor();
        try {
            processor.run(memory);
        } catch (WrongPositionMemoryException e) {
            e.printStackTrace();
        }
    }

    private void initMemory(){
        MemoryFactory memoryFactory = new MemoryFactory();
        memory = memoryFactory.create(reader.getMemory());

    }




}
