package culturoteca.repository.impl;

import culturoteca.model.View;
import culturoteca.repository.ReproducionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryReproduccionRepository implements ReproducionRepository {
    private final List<View> reproducciones = new ArrayList<>();

    @Override
    public List<View> findAll() {
        return List.of();
    }

    @Override
    public View save(View reproducion) {
        reproducciones.add(reproducion); // Agrega a la lista
        return reproducion; // Retorna la entidad agregada
    }
}