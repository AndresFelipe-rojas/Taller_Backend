package culturoteca.service.impl;

import culturoteca.exception.CultureMediaException.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.impl.ImpVideoRepository;
import culturoteca.service.impl.VideoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoServiceImplTest {

    private ImpVideoRepository videoRepository;
    private VideoServiceImpl videoService;

    @BeforeEach
    void setUp() {
        videoRepository = new ImpVideoRepository();
        videoService = new VideoServiceImpl(videoRepository);
    }

    @Test
    void getAllVideos_shouldReturnAllVideos() throws VideoNotFoundException {
        // Arrange
        Video video1 = new Video("001", "Cultura Ciudadana", "Un video sobre cultura", 10.0);
        Video video2 = new Video("002", "Historia de la Ciudad", "Un recorrido histórico", 15.5);
        videoRepository.save(video1);
        videoRepository.save(video2);

        // Act
        List<Video> videos = videoService.getAllVideos();

        // Assert
        assertNotNull(videos);
        assertEquals(2, videos.size());
        assertTrue(videos.contains(video1));
        assertTrue(videos.contains(video2));
    }

    @Test
    void getAllVideos_shouldThrowExceptionIfNoVideosFound() {
        // Arrange: Asegurarse de que el repositorio esté vacío
        videoRepository.findAll().clear();

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, videoService::getAllVideos);
        assertEquals("Video no encontrado.", exception.getMessage());
    }

    @Test
    void findVideoByTitle_shouldReturnVideo() throws VideoNotFoundException {
        // Arrange
        Video video = new Video("003", "Arte Moderno", "Un video sobre arte", 12.0);
        videoRepository.save(video);

        // Act
        Video foundVideo = videoService.findVideoByTitle("Arte Moderno");

        // Assert
        assertNotNull(foundVideo);
        assertEquals("Arte Moderno", foundVideo.title());
    }

    @Test
    void findVideoByTitle_shouldThrowExceptionIfNotFound() {
        // Arrange
        videoRepository.findAll().clear();

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.findVideoByTitle("Inexistente"));
        assertEquals("Video no encontrado: Inexistente", exception.getMessage());
    }
}
