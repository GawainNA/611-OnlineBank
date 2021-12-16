package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdCreator {
    private static Random random = new Random();
    private static Set<Integer> createdInteger = new HashSet<>();
    
    public static long createRandomLong() {
        return Math.abs(random.nextLong());
    }

    public static int createRandomInt() {
        int id = Math.abs(random.nextInt());
        while(createdInteger.contains(id)) {
            id = Math.abs(random.nextInt());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return id;
    }
}
