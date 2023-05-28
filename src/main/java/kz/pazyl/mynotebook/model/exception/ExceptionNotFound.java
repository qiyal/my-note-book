package kz.pazyl.mynotebook.model.exception;

public class ExceptionNotFound extends RuntimeException {
    private String message;

    public ExceptionNotFound() {}

    public ExceptionNotFound(String message) {
        this.message = message;
    }
}
