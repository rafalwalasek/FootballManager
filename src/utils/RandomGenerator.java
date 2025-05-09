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
    public double worth() {
        return 150000 + (random.nextDouble() * 500000);
    }
    public double budget() {
        return 500000 + (random.nextDouble() * 2500000);
    }
    public int goals() {
        return random.nextInt(0, 5);
    }
}
