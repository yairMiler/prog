package entities;

public class InvalidValueException extends Exception {//A class that inherits Exception and throws an invalid value error
    public InvalidValueException(String errorMessage) {
        super(errorMessage);
    }
}
