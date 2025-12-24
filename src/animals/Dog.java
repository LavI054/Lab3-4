package animals;

import enums.CreatureType;
import model.Animal;

public class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, CreatureType.CANINE, age);
    }

    public String sitByOwner() {
        return "Собака " + getName() + " сидит по правую руку";
    }

    @Override
    public String makeSound() {
        return "Гав!";
    }

    @Override
    public String reactToFeeding() {
        return sitByOwner();
    }
}