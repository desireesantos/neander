package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Bus;
import components.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:11 PM
 */
public class NOP implements Instruction {
    public static final int SETUP_NEXTPOSITION = 1;
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

    public NOP(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getAcumulator());
        this.pc = new ProgramCounter(pc.getAddress());
    }

    @Override
    public Bus run() {
        try {
            pc.setAddress(pc.getAddress() + SETUP_NEXTPOSITION );
        } catch (WrongPositionMemoryException e) {
            e.printStackTrace();
        }
        return updateBus();
    }

    private Bus updateBus() {
        Bus bus = new Bus();
        bus.setAcc(acc);
        bus.setPc(pc);
        bus.setMemory(memory);
        return bus;
    }
}
