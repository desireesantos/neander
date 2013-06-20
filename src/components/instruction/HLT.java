package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import static components.Memory.MEMORY_SIZE;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:13 PM
 */
public class HLT implements Instruction {
    public static final int LAST_POSITION_IN_MEMORY = MEMORY_SIZE - 1;
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public HLT(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = memory;
        this.acc = acc;
        this.pc = pc;
    }



    @Override
    public void execute() {
        pc.setValue(LAST_POSITION_IN_MEMORY);
    }
}
