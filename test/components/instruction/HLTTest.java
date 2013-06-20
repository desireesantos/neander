package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static components.Memory.*;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 6/15/13  - Time: 7:46 PM
 */
public class HLTTest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    HLT hlt;
    int lastPositionInMemory = MEMORY_SIZE- 1 ;

    @Before
    public void createComponents(){
        memory = new Memory(new String[00100000]);
        acc = new Acumulator();
        pc = new ProgramCounter();
        hlt = new HLT(memory,acc,pc);
    }

    @Test
    public void executeHLTCommnand()  {
        Assert.assertThat(pc.getValue(), equalTo(0));
        hlt.execute();
        Assert.assertThat(pc.getValue(), equalTo(lastPositionInMemory));
    }
}
