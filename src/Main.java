import enums.Temperament;
import records.Food;
import animals.*;
import exceptions.*;
import java.util.ArrayList;
import items.Rifle;

public class Main {
    public static void main(String[] args) {
        try {
            Human king = new Human("Король");
            king.getProvisions().add(new Food("Рыба", 50));
            king.getProvisions().add(new Food("Фрукты", 30));
            king.getProvisions().add(new Food("Хлеб", 40));
            Parrot popka = new Parrot("Попка", 5);
            Dog dog = new Dog("Старый пёс", 12);
            DomesticCat DomesticCat1 = new DomesticCat("Мурка", 3, Temperament.TAME);
            DomesticCat DomesticCat2 = new DomesticCat("Васька", 4, Temperament.TAME);


            king.addToRetinue(popka);
            king.addToRetinue(dog);
            king.addToRetinue(DomesticCat1);
            king.addToRetinue(DomesticCat2);


            System.out.println("\nСцена 1: Обед");
            king.haveDinner();



            System.out.println("\nСцена 2: Рождение котят");
            ArrayList<DomesticCat> kittens = DomesticCat1.haveLitter();
            System.out.println("Родилось " + kittens.size() + " котят");
            for (DomesticCat kitten : kittens) {
                System.out.print(kitten.getName() + " - ");
                if (kitten.getTemperament() == Temperament.TAME) {
                    System.out.println("домашний");
                }
                else {
                    System.out.println("дикий");
                }
            }

            System.out.println("\nСцена 3: Дикие кошки атакуют");
            WildCat WildCat1 = new WildCat("Дикарь", 2);
            WildCat WildCat2 = new WildCat("Разбойник", 3);
            System.out.println(WildCat1.stealFood(king.getProvisions()));
            System.out.println(WildCat2.stealFood(king.getProvisions()));


            System.out.println("\nСцена 4: Защита ружьём");
            System.out.println(king.tryShootWildAnimal(WildCat1).message());
            System.out.println(king.tryShootWildAnimal(WildCat2).message());

            System.out.println("\nСцена 5: Итог");
            king.checkProvisions();
            System.out.println("Свита: " + king.getRetinue().size() + " существ");
            System.out.println("\n" + king.makeSound());
            System.out.println("Так жил я в этом достатке, ни в чём не нуждаясь, кроме человеческого общества.");
            System.out.println("\nСцена 6: Тест оружия с неверной точностью");
            try {
                Rifle brokenRifle = new Rifle(150); // Неверная точность!
                brokenRifle.shoot();
            } catch (IllegalArgumentException e) {
                System.out.println("Поймано unchecked исключение: " + e.getMessage());
            }
        } catch (ReignViolationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NoFoodException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в оружии: " + e.getMessage());
        }
    }
}