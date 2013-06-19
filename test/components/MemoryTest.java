package components;

import components.instruction.enumcodeinstructions.CodeInstruction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * User: dsantos
 * Date: 6/14/13  - Time: 8:09 PM
 */
public class MemoryTest {
    Memory memory = new Memory();

    @Before
    public void setUp(){
        memory.setMemory(0, "00000000");
        memory.setMemory(1, "00010000");
        memory.setMemory(2, "00010000");
        memory.setMemory(3, "00000111");
        memory.setMemory(4, "00000101");
        memory.setMemory(5, "00001111");
    }


    @Test
    public void inputStringBinaryCodeAndGetInstructionName() throws Exception {
        Assert.assertThat(memory.instructionName("00000000"), is(CodeInstruction.NOP.name()));
        Assert.assertThat(String.valueOf(memory.instructionName("00100000")), equalTo("LDA"));
        Assert.assertThat(String.valueOf(memory.instructionName("00010000")), equalTo("STA"));
        Assert.assertThat(String.valueOf(memory.instructionName("00110000")), equalTo("ADD"));
    }

    @Test
    public void getCodeBinaryThrowIndex() throws Exception {
        Assert.assertThat(memory.getValueMemoryInThisPosition(0), equalTo("00000000"));
        Assert.assertThat(memory.getValueMemoryInThisPosition(3), equalTo("00000111"));
        Assert.assertThat(memory.getValueMemoryInThisPosition(3), equalTo("00000111"));
        Assert.assertThat(memory.getValueMemoryInThisPosition(2), equalTo("00010000"));
    }

    @Test
    public void giveAddressToGetInformation() {
        Assert.assertThat(memory.readAdressInstruction(4), equalTo(15));
    }

    @Test(expected = WrongPositionMemoryException.class)
    public void exceptionWhenSettingIndexNumberOutOfMemory() {
        memory.setMemory(-1,"00010000");
    }
}
