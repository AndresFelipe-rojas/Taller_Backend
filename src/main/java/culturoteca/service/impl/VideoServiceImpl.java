package culturoteca.service.impl;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    // Constructor que recibe el repositorio
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video findVideoByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.find(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return videos.get(0); // Supone que tomas el primer video encontrado.
    }

    @Override
    public List<Video> findVideosByDuration(Double fromDuration, Double toDuration) {
        return videoRepository.find(fromDuration, toDuration);
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
}