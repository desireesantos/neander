package factory;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import components.instruction.*;
import components.instruction.enumcodeinstructions.CodeInstruction;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * User: dsantos
 * Date: 6/14/13  - Time: 12:03 AM
 */
public class InstructionFactoryTest {
    Memory memory = new Memory(new String[8]);
    ProgramCounter pc = new ProgramCounter();
    Acumulator acc = new Acumulator();
    InstructionFactory factory = new InstructionFactory(memory,acc,pc);

    @Test
    public void createNOP()  {
        String type = String.valueOf(CodeInstruction.NOP);
        Assert.assertTrue(factory.create(type) instanceof NOP);
    }

    @Test
    public void createSTA()  {
        String type = String.valueOf(CodeInstruction.STA);
        Assert.assertTrue(factory.create(type) instanceof STA);
    }

    @Test
    public void createLDA()  {
        String type = String.valueOf(CodeInstruction.LDA);
        Assert.assertTrue(factory.create(type) instanceof LDA);
    }

    @Test
    public void createADD()  {
        String type = String.valueOf(CodeInstruction.ADD);
        Assert.assertTrue(factory.create(type) instanceof ADD);
    }

    @Test
    public void createHLT()  {
        String type = String.valueOf(CodeInstruction.HLT);
        Assert.assertTrue(factory.create(type) instanceof HLT);
    }
}
