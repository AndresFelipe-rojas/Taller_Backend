package culturoteca.service.impl;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.service.VideoService;

import java.util.List;

public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideos() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No se encontraron videos en el catálogo.");
        }
        return videos;
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findTitle(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No se encontró un video con el título: " + title);
        }
        return videos.get(0); // Retornar el primero si hay varios con el mismo título.
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findVideosByDuration(fromDuration, toDuration);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No se encontraron videos en el rango de duración especificado.");
        }
        return videos;
    }
}
