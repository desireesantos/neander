package control;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;

/**
 * User: dsantos
 * Date: 6/16/13  - Time: 6:01 PM
 */
public class Bus {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Acumulator getAcc() {
        return acc;
    }

    public void setAcc(Acumulator acc) {
        this.acc = acc;
    }

    public void setPc(ProgramCounter pc) {
        this.pc = pc;
    }
}
