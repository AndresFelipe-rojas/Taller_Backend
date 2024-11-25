package culturoteca.exception;

public class VideoNotFoundException extends Exception {

    // Constructor por defecto
    public VideoNotFoundException() {
        super("Video no encontrado.");
    }

    // Constructor con título
    public VideoNotFoundException(String titulo) {
        super("Video no encontrado: " + titulo);
    }
}
