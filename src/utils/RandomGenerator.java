package utils;

import java.util.Random;

public class RandomGenerator {
    public Random random = new Random();

    public int isValidAge() {
        return random.nextInt(15, 45);
    }
    public int isValidStat() {
        return random.nextInt(1, 100);
    }
}
