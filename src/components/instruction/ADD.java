package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Barramento;
import exception.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:13 PM
 */
public class ADD implements Instruction {
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


    public ADD(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = new Memory(memory.getMemory());
        this.acc = new Acumulator(acc.getAcumulator());
        this.pc = new ProgramCounter(pc.getAddress());
    }

    @Override
    public Barramento create() {
        acc.setAcumulator(memory.instruction(memory.readAdressInstruction(pc.getAddress())) + acc.getAcumulator());
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
