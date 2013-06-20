package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:11 PM
 */
public class NOP implements Instruction {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public NOP(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = memory;
        this.acc = acc;
        this.pc = pc;
    }

    @Override
    public void execute() {

    }

}
