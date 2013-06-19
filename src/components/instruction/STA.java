package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Bus;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:58 PM
 */
public class STA implements Instruction {
    public static final int ONE = 1;
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;

    public ProgramCounter getPc() {
        return pc;
    }

    public Acumulator getAcc() {
        return acc;
    }

    public Memory getMemory() {
        return memory;
    }

    public STA(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getAcumulator());
        this.pc = new ProgramCounter(pc.getAddress());
    }

    @Override
    public Bus run() {
        memory.setMemory(pc.getAddress(), String.valueOf(acc.getAcumulator()));
        pc.setAddress(setNextPosition());
        return updateBus();
    }

    private int setNextPosition() {
        return pc.getAddress() + ONE;
    }

    private Bus updateBus() {
        Bus bus = new Bus();
        bus.setAcc(acc);
        bus.setMemory(memory);
        return bus;
    }
}
