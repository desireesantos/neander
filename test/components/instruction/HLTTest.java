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
 * Date: 6/15/13  - Time: 7:46 PM
 */
public class HLTTest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    HLT hlt;

    @Before
    public void createComponents(){
        memory = new Memory(new String[00100000]);
        acc = new Acumulator();
        pc = new ProgramCounter();
        hlt = new HLT();
    }

    @Test
    public void executeHLTCommnand()  {
        Assert.assertThat(pc.getAddress(), equalTo(0));
        hlt.run();
        Assert.assertThat(hlt.getPc().getAddress(), equalTo(15));
    }
}
