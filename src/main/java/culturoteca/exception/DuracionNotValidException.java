package culturoteca.exception;

public class DuracionNotValidException extends Exception {

    // Constructor con título y duración
    public DuracionNotValidException(String titulo, Double duracion) {
        super("La duración " + duracion + " del video '" + titulo + "' no es válida.");
    }
}
