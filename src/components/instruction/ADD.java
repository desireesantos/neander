package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:13 PM
 */
public class ADD implements Instruction {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public ADD(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = memory;
        this.acc = acc;
        this.pc = pc;
    }

    @Override
    public void execute() {
        acc.setValue(memory.instruction(memory.readAdressInstruction(pc.getValue())) + acc.getValue());
    }
}
