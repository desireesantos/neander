package components;

import components.instruction.enumcodeinstructions.CodeInstruction;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:04 AM
 */
public class Memory {

    public static final int MEMORY_SIZE = 16;
    public static final int DECIMAL_BASE = 2;
    public static final int WRONG_POSITION = 0;
    public static final String NO_NAME = null;
    public static final int MIN_POSITION = 0;
    private String[] memory = new String[MEMORY_SIZE];

    public Memory(String[] memory) {
        this.memory = memory;
    }

    public Memory() {
    }

    public String[] getMemory() {
        return memory;
    }

    public void setMemory(int index, String newValue) {

        if(isValidAdress(index))
            this.memory[index] = newValue;
    }

    public int readAdressInstruction(int address) {
        return isValidAdress(address) ? stringInBinaryFormatBecomeInt(memory[++address]) : WRONG_POSITION;
    }

    private boolean isValidAdress(int index) {
        if (index < MEMORY_SIZE && index >= MIN_POSITION)
            return true;
        else
                throw new WrongPositionMemoryException();


    }

    public int instruction(int address) {
        return isValidAdress(address) ? stringInBinaryFormatBecomeInt(memory[address]) : WRONG_POSITION;
    }

    public String getValueMemoryInThisPosition(int index) {

        if(isValidAdress(index))
            return memory[index];

        return NO_NAME;
    }

    public String instructionName(String binaryCode) {
        for(CodeInstruction codeInstruction: CodeInstruction.values()){
            if(codeInstruction.getValue().equals(binaryCode.toString())) {
                return codeInstruction.toString();
            }
        }
        return NO_NAME;
    }

    private int stringInBinaryFormatBecomeInt(String s) {
        return Integer.parseInt(s, DECIMAL_BASE);
    }
}
