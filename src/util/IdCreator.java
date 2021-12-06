package util;

import java.util.Random;

public class IdCreator {
    private static Random random = new Random();
    public static long createRandomLong() {
        return Math.abs(random.nextLong());
    }

    public static int createRandomInt() {
        return Math.abs(random.nextInt());
    }
}
