package components;

/**
 * User: dsantos
 * Date: 6/6/13  - Time: 6:02 PM
 */
public class WrongPositionMemoryException extends RuntimeException {
    private String msg = "Not valid position in memory";

    public String getMessage(){
        return msg;
    }

}
