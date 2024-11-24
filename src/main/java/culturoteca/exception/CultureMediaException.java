package culturoteca.exception;

public class CultureMediaException extends Exception {
    public CultureMediaException(String message) {
        super(message);
    }

    // Clase interna para manejar la excepción VideoNotFoundException
    public static class VideoNotFoundException extends CultureMediaException {
        private String titulo;

        // Constructor por defecto
        public VideoNotFoundException() {
            super("Video no encontrado.");
        }

        // Constructor con título
        public VideoNotFoundException(String titulo) {
            super("Video no encontrado: " + titulo);
            this.titulo = titulo;
        }

        // Método para obtener el título del video
        public String getTitulo() {
            return titulo;
        }
    }
}
