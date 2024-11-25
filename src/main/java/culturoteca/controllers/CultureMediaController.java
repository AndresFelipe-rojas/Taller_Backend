package culturoteca.controllers;

import culturoteca.exception.VideoNotFoundException;
import culturoteca.exception.DuracionNotValidException;
import culturoteca.model.Video;
import culturoteca.service.VideoService;

import java.util.List;

public class CultureMediaController {

    private final VideoService videoService;

    public CultureMediaController(VideoService videoService) {
        this.videoService = videoService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        return videoService.getAllVideos();
    }

    public Video findVideoByTitle(String title) throws VideoNotFoundException {
        return videoService.findByTitle(title);
    }

    public List<Video> findVideosByDuration(Double fromDuration, Double toDuration) throws DuracionNotValidException {
        return videoService.findByDuration(fromDuration, toDuration);
    }

    public Video addVideo(Video video) {
        return videoService.addVideo(video);
    }
}

