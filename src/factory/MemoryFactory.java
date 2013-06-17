package factory;

import components.Memory;

/**
 * User: dsantos
 * Date: 6/11/13  - Time: 6:45 PM
 */
public class MemoryFactory {

    public Memory create(String[] createMemory){
        return new Memory(createMemory);
    }
}
