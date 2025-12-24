package animals;

import enums.*;
import model.Animal;

public abstract class Pet extends Animal {
    public Pet(String name, CreatureType type, int age) {
        super(name, type, age, Temperament.TAME);
    }
}