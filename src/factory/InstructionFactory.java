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

    public Instruction execute(Memory memory, Acumulator acc, ProgramCounter pc, String typeInstruction) {
        Instruction instruction = null;


        if (typeInstruction.equals(NOP.toString()))
            instruction = new NOP(memory,acc,pc);
        else if(typeInstruction.equals(LDA.toString()))
            instruction = new LDA(memory,acc,pc);
        else if(typeInstruction.equals(ADD.toString()))
            instruction = new ADD(memory,acc,pc);
        else if(typeInstruction.equals(HLT.toString()))
            instruction =  new HLT(memory,acc,pc);
        else if(typeInstruction.equals(STA.toString()))
            instruction =  new STA(memory,acc,pc);
        else
        {
            new WrongInstructionException();
        }
        return instruction;
    }
}
