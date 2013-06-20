package components.instruction;

/**
 * User: dsantos
 * Date: 6/16/13  - Time: 3:48 PM
 */
public class WrongInstructionException extends RuntimeException {
    public static final String msg = "Not valid instruction ";

    public String getMessage(){
        return msg;
    }
}
