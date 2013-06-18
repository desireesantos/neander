package processor;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Barramento;
import exception.WrongPositionMemoryException;
import factory.InstructionFactory;

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

        for (int i = 0; i <= Memory.MEMORY_SIZE -1; i= i + READ_ONLY_INSTRUCTIONS) {
            pc.setAddress(i);
            String nameInstruction = currentInstructionName(memory, pc);

            if(isNotNull(nameInstruction))
                processInstructions(nameInstruction);
            else
                break;
        }
    }

    private void processInstructions(String nameInstruction) throws WrongPositionMemoryException {
        InstructionFactory instructionFactory = new InstructionFactory();
        Barramento barramento = instructionFactory.execute(memory,acc,pc,nameInstruction).create();
        updateComponents(barramento);
    }

    private boolean isNotNull(String nameInstruction) {
        return nameInstruction != null;
    }

    private String currentInstructionName(Memory memory, ProgramCounter pc) {
        return memory.instructionName(memory.getValueMemoryInThisPosition(pc.getAddress()));
    }

    private void updateComponents(Barramento instruction) {
        this.memory = instruction.getMemory();
        this.acc = instruction.getAcc();

    }
}
