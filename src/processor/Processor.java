package processor;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import components.instruction.Instruction;
import components.WrongPositionMemoryException;
import factory.InstructionFactory;
import io.Monitor;

import static components.Memory.MEMORY_SIZE;
import static components.Memory.WRONG_POSITION;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:09 AM
 */
public class  Processor {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public void run(Memory memory) throws WrongPositionMemoryException {
        this.memory = new Memory(memory.getMemory());
        acc = new Acumulator();
        pc = new ProgramCounter();
        processInstructions();
    }


    private void processInstructions() throws WrongPositionMemoryException {
        final int  READ_ONLY_INSTRUCTIONS = 2;

        int count=0;
        while (count < memory.getMemory().length ) {
            pc.setValue(count);
            String nameInstruction = currentInstructionName(memory, pc);
            processInstructions(nameInstruction);

            count += READ_ONLY_INSTRUCTIONS;
        }

        Monitor monitor = new Monitor();
        monitor.print(memory);
    }

    private void processInstructions(String nameInstruction) throws WrongPositionMemoryException {
        InstructionFactory instructionFactory = new InstructionFactory(memory, acc, pc);
        Instruction  instruction = instructionFactory.create(nameInstruction) ;
        instruction.execute();
    }


    private String currentInstructionName(Memory memory, ProgramCounter pc) {
        return memory.instructionName(memory.getValueMemoryInThisPosition(pc.getValue()));
    }

}
