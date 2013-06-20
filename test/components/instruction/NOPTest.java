package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
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
    public void NothingShouldChangeInNOPCommand(){
        acc.setValue(3);
        pc.setValue(1);

        nop = new NOP(memory,acc,pc);
        nop.execute();
        Assert.assertThat(acc.getValue(), equalTo(3));
    }


}
