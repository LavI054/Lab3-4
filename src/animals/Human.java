package animals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import enums.*;
import records.Food;
import records.ShotResult;
import model.Animal;
import exceptions.*;
import items.*;
import java.util.ArrayList;
import java.util.Random;

public class Human extends Animal {
    private ArrayList<Animal> retinue;
    private ArrayList<Food> provisions;
    private Weapon weapon;
    private FeedingStat feedingStat;
    private static final Random random = new Random();

    public Human(String name) {
        super(name, CreatureType.HUMAN, 35, Temperament.TAME);
        this.retinue = new ArrayList<>();
        this.provisions = new ArrayList<>();
        this.weapon = new Rifle(70);
        this.feedingStat = new FeedingStat();
    }

    public void addToRetinue(Animal animal) throws ReignViolationException {
        if (animal.getTemperament() == Temperament.WILD) {
            throw new ReignViolationException("Дикое животное не может быть в свите");
        }
        retinue.add(animal);
        System.out.println(animal.getName() + " добавлен в свиту");
    }

    public void haveDinner() throws NoFoodException {
        System.out.println("Королевский обед");
        System.out.println(getName() + " восседает за столом");

        if (provisions.isEmpty()) {
            throw new NoFoodException("свиты");
        }

        int random_provisions = random.nextInt(0, provisions.size());
        int random_cnt = random.nextInt(1, provisions.get(random_provisions).nutrition());
        Food foodToEat = provisions.get(random_provisions);

        int eatAmount = random_cnt;

        if (eatAmount >= foodToEat.nutrition()) {
            provisions.remove(random_provisions);
        } else {
            Food remaining = new Food(foodToEat.name(), foodToEat.nutrition() - eatAmount);
            provisions.set(random_provisions, remaining);
        }

        System.out.println(getName() + " съел " + eatAmount + " единиц " + foodToEat.name());

        for (Animal animal : retinue) {
            System.out.println(animal.reactToFeeding());
        }

        if (!retinue.isEmpty() && !provisions.isEmpty()) {
            int r = random.nextInt(0, retinue.size());
            Animal chosenAnimal = retinue.get(r);
            System.out.println(getName() + ": " + chosenAnimal.getName() + ", голос!");
            System.out.println(chosenAnimal.getName() + ": " + chosenAnimal.makeSound());

            int rr = random.nextInt(0, provisions.size());
            int cnt = random.nextInt(1, provisions.get(rr).nutrition());

            Food treatFood = provisions.get(rr);
            System.out.println(getName() + " кормит " + chosenAnimal.getName() + " " + treatFood.name());

            feedingStat.recordFeeding();

            chosenAnimal.eat(treatFood, cnt);
            if (cnt >= treatFood.nutrition()) {
                provisions.remove(rr);
            } else {
                Food remaining = new Food(treatFood.name(), treatFood.nutrition() - cnt);
                provisions.set(rr, remaining);
            }
        }
    }

    public ShotResult tryShootWildAnimal(Animal animal) {
        if (animal.getTemperament() == Temperament.WILD) {
            boolean hit = weapon.shoot();
            String message = hit ? getName() + " попал в " + animal.getName()
                    : getName() + " промахнулся по " + animal.getName();

            return new ShotResult(hit, message);

        }
        return new ShotResult(false, "Нельзя стрелять в ручных животных");
    }

    public void checkProvisions() {
        if (provisions.isEmpty()) {
            System.out.println("Провизия: ПУСТО");
            return;
        }

        System.out.println("Провизия (" + provisions.size() + " видов):");
        int totalNutrition = 0;

        for (Food food : provisions) {
            System.out.println("- " + food.name() + ": " + food.nutrition() + " единиц");
            totalNutrition += food.nutrition();
        }

        System.out.println("Всего единиц: " + totalNutrition);
    }

    public class FeedingStat {
        private int totalFeedings = 0;

        public void recordFeeding() {
            totalFeedings++;
        }

        public int getTotalFeedings() {
            return totalFeedings;
        }
    }

    public ArrayList<Animal> getRetinue() {
        return retinue;
    }

    public ArrayList<Food> getProvisions() {
        return provisions;
    }

    @Override
    public String makeSound() {
        return "Я король этого острова!";
    }

    @Override
    public String reactToFeeding() {
        return getName() + " величественно восседает за столом";
    }
}