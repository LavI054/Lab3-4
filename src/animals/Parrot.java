package animals;

import enums.CreatureType;
import model.Animal;

public class Parrot extends Pet {
    public Parrot(String name, int age) {
        super(name, CreatureType.BIRD, age);
    }

    public String talk(String phrase) {
        return "Попугай " + getName() + " говорит: \"" + phrase + "\"";
    }

    @Override
    public String makeSound() {
        return "Каррр!";
    }

    @Override
    public String reactToFeeding() {
        return talk("Да здравствует король!");
    }
}