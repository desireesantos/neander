package io;

import components.Memory;

/**
 * User: dsantos
 * Date: 6/2/13  - Time: 12:10 AM
 */
public class Monitor {

    public static final int ONE = 1;

    public void print(Memory memory) {
        System.out.println(" Memory Inside: ");
        for (int x=0; x < Memory.MEMORY_SIZE ;x++ ){
            System.out.println("Index(" +x+ "): "+  memory.getValueMemoryInThisPosition(x).toString());
        }


    }
}
