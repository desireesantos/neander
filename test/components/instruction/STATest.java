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
 * Date: 6/16/13  - Time: 1:20 AM
 */
public class STATest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    STA sta;

    @Before
    public void createComponents(){
        memory = new Memory();
        acc = new Acumulator();
        pc = new ProgramCounter();
        memory.setMemory(0, "00100000");
        memory.setMemory(1, "00000010");
        memory.setMemory(2, "00000000");
        memory.setMemory(3, "00000000");
    }

    @Test
    public void validCommand() {
        acc.setValue(49);
        pc.setValue(0);
        sta = new STA(memory,acc,pc);
        sta.execute();

    }

    @Test (expected = WrongPositionMemoryException.class)
    public void inValidCommandCallWrongPositionException() {
        acc.setValue(49);
        pc.setValue(-1);
        sta = new STA(memory,acc,pc);
        sta.execute();
    }

}
