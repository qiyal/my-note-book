package kz.pazyl.mynotebook.model.exception;

public class EntityNotFoundException extends RuntimeException {
    private Long id;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
