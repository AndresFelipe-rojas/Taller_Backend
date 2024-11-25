package culturoteca.service.impl;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.service.VideoService;

import java.util.List;
import java.util.Optional;

public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    // Constructor para inyectar el repositorio
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideos() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }

    @Override
    public Video findVideoByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findTitle(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        // Devuelve el primer video encontrado
        return videos.get(0);
    }

    @Override
    public List<Video> findVideosByDuration(Double fromDuration, Double toDuration) {
        return videoRepository.findVideosByDuration(fromDuration, toDuration);
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
}
