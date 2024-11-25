package culturoteca.service.impl;

import culturoteca.exception.VideoNotFoundException;
import culturoteca.exception.DuracionNotValidException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

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
    public Video findByTitle(String title) throws VideoNotFoundException {
        List<Video> videos = videoRepository.findByTitle(title);
        if (videos.isEmpty()) {
            throw new VideoNotFoundException(title);
        }
        return videos.get(0);  // Si existe, retorna el primer video
    }

    @Override
    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws DuracionNotValidException {
        List<Video> videos = videoRepository.findByDurationBetween(fromDuration, toDuration);
        if (videos.isEmpty()) {
            throw new DuracionNotValidException("N/A", 0.0);  // Puedes cambiar los valores según tu lógica
        }
        return videos;
    }

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
}
