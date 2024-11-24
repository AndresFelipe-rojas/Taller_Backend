package culturoteca.repository.impl;

import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImpVideoRepository implements VideoRepository {
    private final List<Video> videos = new ArrayList<>();

    @Override
    public List<Video> findAll() {
        return List.of();
    }

    @Override
    public Video save(Video save) {
        return null;
    }

    @Override
    public List<Video> find(String title) {
        return List.of();
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) {
        return List.of();
    }
}