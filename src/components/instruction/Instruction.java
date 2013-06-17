package components.instruction;

import components.Acumulator;
import components.Memory;
import components.ProgramCounter;
import control.Barramento;
import exception.WrongPositionMemoryException;

/**
 * User: dsantos
 * Date: 6/11/13  - Time: 6:46 PM
 */
public interface Instruction {

    public Barramento create() throws WrongPositionMemoryException;
    public Memory getMemory();
    public Acumulator getAcc();
    public ProgramCounter getPc();


}
