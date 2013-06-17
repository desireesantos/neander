package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Barramento;
import exception.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:58 PM
 */
public class STA implements Instruction {
    public static final int SETUP_NEXTPOSITION = 1;


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
    public Barramento create() {
        memory.setMemory(memory.readAdressInstruction(pc.getAddress()), String.valueOf(acc.getAcumulator()));
        try {
            pc.setAddress(pc.getAddress() + SETUP_NEXTPOSITION );
        } catch (WrongPositionMemoryException e) {
            e.printStackTrace();
        }
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
