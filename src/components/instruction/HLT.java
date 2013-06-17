package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Barramento;
import exception.WrongPositionMemoryException;
import io.Monitor;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:13 PM
 */
public class HLT implements Instruction {
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
    public Barramento create() throws WrongPositionMemoryException {
        pc.setAddress(Memory.MEMORY_SIZE - ONE);

        Monitor monitor = new Monitor();
        monitor.print(memory);
        return updateBarramento();
    }

    private Barramento updateBarramento() {
        Barramento barramento = new Barramento();
        barramento.setAcc(acc);
        barramento.setPc(pc);
        barramento.setMemory(memory);
        return barramento;
    }
}
