package pl.dominisz.springintroduction.exception;

public class UnreachableException extends RuntimeException {
    public UnreachableException(String message) {
        super(message);
    }
}
