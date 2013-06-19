package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Bus;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:12 PM
 */
public class LDA implements Instruction {

    public static final int ONE = 1;
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

    public LDA(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getAcumulator());
        this.pc = new ProgramCounter(pc.getAddress());
    }

    @Override
    public Bus run() {
        acc.setAcumulator(memory.instruction(memory.readAdressInstruction(pc.getAddress())));
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
