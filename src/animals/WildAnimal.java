package animals;

import enums.*;
import records.Food;
import model.Animal;
import java.util.ArrayList;
import java.util.Random;

public abstract class WildAnimal extends Animal {
    public WildAnimal(String name, CreatureType type, int age) {
        super(name, type, age, Temperament.WILD);
    }

    private static final Random random = new Random();
    public String stealFood(ArrayList<Food> provisions) {
        if (!provisions.isEmpty()) {
            int r = random.nextInt(0, provisions.size());
            Food food = provisions.get(r);


            if (random.nextDouble() < 0.6) {

                int stealPercent = 30 + random.nextInt(71); // 30-100%
                int stolenAmount = food.nutrition() * stealPercent / 100;

                if (stolenAmount >= food.nutrition()) {

                    provisions.remove(r);
                    return "Дикая кошка " + getName() + " украла ВСЮ " + food.name();
                } else {

                    Food remaining = new Food(food.name(), food.nutrition() - stolenAmount);
                    provisions.set(r, remaining);
                    return "Дикая кошка " + getName() + " украла " + stolenAmount
                            + " единиц из " + food.name();
                }
            }
            return "Дикая кошка " + getName() + " пыталась украсть, но не получилось";
        }
        return "Дикая кошка " + getName() + " не нашла еды";
    }
}