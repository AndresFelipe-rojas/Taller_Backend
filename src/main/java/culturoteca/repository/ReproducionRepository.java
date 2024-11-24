package culturoteca.repository;

import culturoteca.model.View;
import java.util.List;

public interface ReproducionRepository {
    List<View> findAll();
    View save(View reproducion);
}