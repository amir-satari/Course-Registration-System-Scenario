package ir.maktabsharif.exception;

public class courseNotFoundException extends RuntimeException {
    public courseNotFoundException(String message) {
        super(message);
    }
}
