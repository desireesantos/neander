package components;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * User: dsantos
 * Date: 6/6/13  - Time: 5:51 PM
 */
public class AddressTest {

    ProgramCounter address = new ProgramCounter();

    @Test
    public void validAddress() throws WrongPositionMemoryException {
        address.setValue(7);
        Assert.assertThat(address.getValue(), equalTo(7));
    }

    @Test (expected = WrongPositionMemoryException.class)
    public void noValidAddress() throws WrongPositionMemoryException{
        address.setValue(17);
    }
}
