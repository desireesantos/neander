package factory;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import components.instruction.*;
import components.instruction.WrongInstructionException;

import static components.instruction.enumcodeinstructions.CodeInstruction.*;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:02 PM
 *
 */
public class InstructionFactory {

    private Memory memory;
    private Acumulator acc;
    private ProgramCounter pc;

    public InstructionFactory(Memory memory, Acumulator acc, ProgramCounter pc) {
        this.memory = memory;
        this.acc = acc;
        this.pc = pc;
    }

    public Instruction create(String typeInstruction) {

         if(typeInstruction.equals(LDA.toString()))
            return new LDA(memory,acc,pc);
        else if(typeInstruction.equals(ADD.toString()))
            return new ADD(memory,acc,pc);
        else if(typeInstruction.equals(HLT.toString()))
            return  new HLT(memory,acc,pc);
        else if(typeInstruction.equals(STA.toString()))
            return  new STA(memory,acc,pc);

        return new NOP(memory,acc,pc);


    }
}
