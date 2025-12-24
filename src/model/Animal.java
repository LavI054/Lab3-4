package model;

import enums.*;
import records.Food;

public abstract class Animal extends LivingBeing implements Eater {
    protected int age;
    protected Temperament temperament;
    protected boolean isHungry;

    public Animal(String name, CreatureType type, int age, Temperament temperament) {
        super(name, type);
        this.age = age;
        this.temperament = temperament;
        this.isHungry = true;
    }

    public abstract String reactToFeeding();

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Animal)) return false;

        Animal other = (Animal) obj;
        return age == other.age &&
                temperament == other.temperament &&
                isHungry == other.isHungry;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + age * 31 + temperament.hashCode() + Boolean.hashCode(isHungry);
    }

    @Override
    public void eat(Food food, int cnt) {
        isHungry = false;
        System.out.println(getName() + " ест " + cnt +" единиц " + food.name());
    }

    @Override
    public String makeSound() {
        return "Животное издаёт звук";
    }

    public Temperament getTemperament() {
        return temperament;
    }
}