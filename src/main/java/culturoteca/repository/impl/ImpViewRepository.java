package culturoteca.repository.impl;

import java.util.ArrayList;
import java.util.List;

import culturoteca.model.View;
import culturoteca.repository.ViewRepository;

public class ImpViewRepository implements ViewRepository {

    private final List<View> views;

    public ImpViewRepository() {
        this.views = new ArrayList<>();
    }

    @Override
    public View save(View view) {
        this.views.add( view );
        return view;
    }
}
