package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import exception.WrongPositionMemoryException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 6/14/13  - Time: 1:20 AM
 */
public class ADDTest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    ADD add;

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
    public void hasAddValueInMemory() throws Exception, WrongPositionMemoryException {
        acc.setAcumulator(3);
        pc.setAddress(1);
        add = new ADD(memory,acc,pc);
        Assert.assertThat(add.getAcc().getAcumulator(), equalTo(3));
        add.create();
        Assert.assertThat(add.getAcc().getAcumulator(), equalTo(10));

    }



}
