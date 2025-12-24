package exceptions;

public class ReignViolationException extends Exception{
    private final String violation;

    public ReignViolationException(String violation) {
        this.violation = violation;
    }

    @Override
    public String getMessage() {
        return "Нарушение правления: " + violation;
    }

    public String getViolation() {
        return violation;
    }
}
