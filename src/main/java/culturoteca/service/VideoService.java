package culturoteca.service;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;

import java.util.List;

public interface VideoService {
    // Método para obtener todos los videos
    List<Video> getAllVideos();

    // Método para buscar videos por título
    Video findVideoByTitle(String title) throws VideoNotFoundException;

    // Método para buscar videos por rango de duración
    List<Video> findVideosByDuration(Double fromDuration, Double toDuration);

    // Método para agregar un nuevo video
    Video addVideo(Video video);
}