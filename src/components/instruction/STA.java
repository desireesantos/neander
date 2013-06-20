package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:58 PM
 */
public class STA implements Instruction {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public STA(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getValue());
        this.pc = new ProgramCounter(pc.getValue());
    }

    @Override
    public void execute() {
        memory.setMemory( memory.readAdressInstruction(pc.getValue()), String.valueOf(acc.getValue()));
    }


}
