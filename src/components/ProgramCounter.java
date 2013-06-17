package components;

import exception.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:05 AM
 */
public class ProgramCounter {

    public static final int MIN_POSITION = 4;
    public static final int MAX_POSITION = Memory.MEMORY_SIZE;
    private int address =0;

    public ProgramCounter(int pc) {
        address =pc;
    }

    public ProgramCounter() {
    }


    public int getAddress() {
        return address;
    }

    public void setAddress(int address) throws WrongPositionMemoryException {
        if(isValid(address))
            this.address = address;
        else
              throw new WrongPositionMemoryException();
    }

    private boolean isValid(int address) {
        return  address <=MAX_POSITION;
    }
}
