package exceptions;

public class NoFoodException extends Exception{
    private final String animalName;

    public NoFoodException(String animalName) {
        super("Нет еды для " + animalName);
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }
}
