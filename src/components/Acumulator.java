package components;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:05 AM
 */
public class Acumulator {

    private int acumulator = 0;

    public Acumulator(int acc) {
        acumulator = acc;
    }

    public Acumulator() {
    }

    public int getAcumulator() {
        return acumulator;
    }

    public void setAcumulator(int acumulator) {
        this.acumulator = acumulator;
    }

}
