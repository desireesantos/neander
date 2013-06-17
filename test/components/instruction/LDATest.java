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
 * Date: 6/16/13  - Time: 2:15 AM
 */
public class LDATest {
    Memory memory;
    Acumulator acc;
    ProgramCounter pc;
    LDA lda;

    @Before
    public void createComponents(){
        memory = new Memory();
        acc = new Acumulator();
        pc = new ProgramCounter();
        memory.setMemory(0, "00100000");
        memory.setMemory(1, "00000010");
        memory.setMemory(2, "00000111");
        memory.setMemory(3, "00000000");
    }

    @Test
    public void create() throws WrongPositionMemoryException {
        acc.setAcumulator(3);
        pc.setAddress(2);
        lda = new LDA(memory,acc,pc);

        Assert.assertThat(acc.getAcumulator(), equalTo(3));
        lda.create();
        Assert.assertThat(lda.getAcc().getAcumulator(), equalTo(7));

    }


}
