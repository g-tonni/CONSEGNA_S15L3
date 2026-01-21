package giada_tonni.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("L'evento con id " + id + " non è stato trovato");
    }
}
