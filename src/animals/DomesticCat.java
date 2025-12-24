package animals;

import enums.*;
        import records.Food;
import model.Animal;
import java.util.ArrayList;
import java.util.Random;

public class DomesticCat extends Pet {
    public DomesticCat(String name, int age, Temperament temperament) {
        super(name, CreatureType.FELINE, age);
    }
    private static final Random random = new Random();


    public ArrayList<DomesticCat> haveLitter() {
        ArrayList<DomesticCat> kittens = new ArrayList<>();
        int count = 2 + random.nextInt(3);
        for (int i = 0; i < count; i++) {
            boolean isTame = random.nextBoolean();
            Temperament kittenTemperament = isTame ? Temperament.TAME : Temperament.WILD;
            DomesticCat kitten = new DomesticCat("Котёнок " + (i + 1), 0, kittenTemperament);
            kittens.add(kitten);
        }
        return kittens;
    }

    @Override
    public String makeSound() {
        return "Мяу!";
    }

    @Override
    public String reactToFeeding() {
        return getName() + " смотрит, ожидая подачки";
    }
}
