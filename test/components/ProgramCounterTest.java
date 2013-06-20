package components;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 6/15/13  - Time: 8:36 PM
 */
public class ProgramCounterTest {

    ProgramCounter pc;

    @Before
    public void setTup(){
        pc = new ProgramCounter();
    }



    @Test
    public void validAddress(){
        Assert.assertThat(pc.getValue(), equalTo(0));
        pc.setValue(8);
        Assert.assertThat(pc.getValue(), equalTo(8));
        pc.setValue(16);
        Assert.assertThat(pc.getValue(), equalTo(16));
    }


    @Test (expected =WrongPositionMemoryException.class )
    public void throwsExceptionWhenSettingAddressInPositionOutOfMemory() throws WrongPositionMemoryException {
        pc.setValue(Memory.MEMORY_SIZE + 1);
    }

    @Test (expected =WrongPositionMemoryException.class )
    public void throwsExceptionWhenSettingNegativeIndexInMemory() throws WrongPositionMemoryException {
        pc.setValue(-2);
    }
}
