package components;

import components.instruction.enumcodeinstructions.CodeInstruction;
import exception.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:04 AM
 */
public class Memory {

    public static final int MEMORY_SIZE = 16;
    public static final int DECIMAL_BASE = 2;
    private String[] memory = new String[MEMORY_SIZE];


    public Memory(String[] memory) {
        this.memory = memory;
    }

    public Memory() {
    }

    public String[] getMemory() {
        return memory;
    }

    public void setMemory(int value, String insertValue) {
        this.memory[value] = insertValue;
    }


    public int readAdressInstruction(int address) {
        return stringInBinaryFormatBecomeInt(memory[++address]);
    }

    public int instruction(int address) {
        return stringInBinaryFormatBecomeInt(memory[address]);
    }

    public String getValueMemoryInThisPosition(int index) {
        return memory[index];
    }

    public String instructionName(String binaryCode) {
        for(CodeInstruction codeInstruction: CodeInstruction.values()){
            if(codeInstruction.getValue().equals(binaryCode.toString())) {
                return codeInstruction.toString();
            }
        }
        return null;
    }

    private int stringInBinaryFormatBecomeInt(String s) {
        return Integer.parseInt(s, DECIMAL_BASE);
    }
}
