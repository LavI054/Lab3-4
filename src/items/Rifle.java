package items;

import java.util.Random;

public class Rifle implements Weapon{
    private int accuracy;
    private Random random;

    public Rifle(int accuracy) {
        this.accuracy = accuracy;
        this.random = new Random();
    }

    @Override
    public boolean shoot() {
        if (accuracy > 100 || accuracy < 0) {
            throw new IllegalArgumentException("Точность должна быть 0-100");
        }
        return random.nextInt(100) < accuracy;
    }

    @Override
    public int getAccuracy() {
        return accuracy;
    }
}