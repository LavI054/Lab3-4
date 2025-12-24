package model;

import enums.CreatureType;

public abstract class LivingBeing {
    private final String name;
    private final CreatureType type;

    public LivingBeing(String name, CreatureType type) {
        this.name = name;
        this.type = type;
    }

    public abstract String makeSound();

    public String getName() {
        return name;
    }

    public CreatureType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Это " + type + ", его зовут " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        LivingBeing other = (LivingBeing) obj;

        return name.equals(other.name) && type == other.type;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode();
    }
}
