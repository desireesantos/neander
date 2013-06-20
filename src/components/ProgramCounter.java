package components;

import static components.Memory.*;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:05 AM
 */
public class ProgramCounter {

    public static final int MAX_POSITION = MEMORY_SIZE;
    public static final int MIN_POSITION = 0;
    private int address =0;

    public ProgramCounter(int pc) {
        address =pc;
    }

    public ProgramCounter() {
    }

    public int getValue() {
        return address;
    }

    public void setValue(int address) throws WrongPositionMemoryException {
        if(isValid(address))
            this.address = address;
        else
              throw new WrongPositionMemoryException();
    }

    private boolean isValid(int address) {
        return  address >= MIN_POSITION && address <= MAX_POSITION;
    }
}
