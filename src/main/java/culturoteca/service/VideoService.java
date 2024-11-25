package culturoteca.service;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;

import java.util.List;

public interface VideoService {
    List<Video> getAllVideos() throws VideoNotFoundException;

    Video addVideo(Video video);

    Video findByTitle(String title) throws VideoNotFoundException;

    List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException;
}
