package components;

import exception.WrongPositionMemoryException;
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
    public void validAddress() throws Exception, WrongPositionMemoryException {
        Assert.assertThat(pc.getAddress(), equalTo(0));
        pc.setAddress(8);
        Assert.assertThat(pc.getAddress(), equalTo(8));
        pc.setAddress(16);
        Assert.assertThat(pc.getAddress(), equalTo(16));
    }


    @Test (expected =WrongPositionMemoryException.class )
    public void invalidAddress() throws Exception, WrongPositionMemoryException {
        pc.setAddress(17);
    }
}
