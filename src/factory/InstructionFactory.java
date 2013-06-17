package factory;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import components.instruction.*;
import components.instruction.enumcodeinstructions.CodeInstruction;
import exception.WrongInstructionException;

/**
 * User: dsantos
 * Date: 6/13/13  - Time: 11:02 PM
 *
 */
public class InstructionFactory {


    public Instruction execute(Memory memory, Acumulator acc, ProgramCounter pc, String typeInstruction) {
        Instruction instruction = null;

        if (typeInstruction.equals(CodeInstruction.NOP.toString()))
            instruction = new NOP(memory,acc,pc);
        else if(typeInstruction.equals(CodeInstruction.LDA.toString()))
            instruction = new LDA(memory,acc,pc);
        else if(typeInstruction.equals(CodeInstruction.ADD.toString()))
            instruction = new ADD(memory,acc,pc);
        else if(typeInstruction.equals(CodeInstruction.HLT.toString()))
            instruction =  new HLT(memory,acc,pc);
        else if(typeInstruction.equals(CodeInstruction.STA.toString()))
            instruction =  new STA(memory,acc,pc);
        else
        {
            try {
                throw new WrongInstructionException();
            } catch (WrongInstructionException e) {
                e.printStackTrace();
            }
        }

        return instruction;
    }
}
