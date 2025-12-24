package animals;

import enums.*;

public class WildCat extends WildAnimal {
    public WildCat(String name, int age) {
        super(name, CreatureType.FELINE, age);
    }

    @Override
    public String makeSound() {
        return "Шшш!";
    }

    @Override
    public String reactToFeeding() {
        return getName() + " рычит и отказывается от еды";
    }
}
