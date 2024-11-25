package culturoteca.model;

public record Video(String code, String title, String description, Double Duration){

    public Double duration() {
        return 0.0;
    }
}