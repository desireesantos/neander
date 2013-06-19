package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Bus;
import io.Monitor;

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

    @Override
    public Memory getMemory() {
        return memory;
    }

    @Override
    public Acumulator getAcc() {
        return acc;
    }

    @Override
    public ProgramCounter getPc() {
        return pc;
    }

    public HLT(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getAcumulator());
        this.pc = new ProgramCounter(pc.getAddress());
    }

    public HLT() {
        this.memory = new Memory();
        this.acc = new Acumulator();
        this.pc = new ProgramCounter();
    }

    @Override
    public Bus run()  {
        pc.setAddress(LAST_POSITION_IN_MEMORY);
        return updateBus();
    }

    private Bus updateBus() {
        Bus bus = new Bus();
        bus.setAcc(acc);
        bus.setMemory(memory);
        return bus;
    }
}
