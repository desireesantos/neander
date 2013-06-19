package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import components.WrongPositionMemoryException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 6/16/13  - Time: 1:11 AM
 */
public class NOPTest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    NOP nop;

    @Before
    public void createComponents(){
        memory = new Memory();
        acc = new Acumulator();
        pc = new ProgramCounter();
        memory.setMemory(0, "00100000");
        memory.setMemory(1, "00000010");
        memory.setMemory(2, "00000111");
    }

    @Test
    public void nopCommandNothingShouldChange(){
        acc.setAcumulator(3);
        pc.setAddress(1);
        nop = new NOP(memory,acc,pc);
        Assert.assertThat(nop.getAcc().getAcumulator(), equalTo(3));
        nop.run();
        Assert.assertThat(nop.getAcc().getAcumulator(), equalTo(3));

    }

    @Test
    public void nop() {
        acc.setAcumulator(4);
        pc.setAddress(1);
        nop = new NOP(memory,acc,pc);
        nop.run();
        Assert.assertThat(nop.getAcc().getAcumulator(), equalTo(3));
        Assert.assertThat(nop.getAcc().getAcumulator(), equalTo(2));

    }



}
