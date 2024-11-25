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
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        // Arrange
        Video video1 = new Video("001", "Cultura Ciudadana", "Un video sobre cultura", 10.0);
        Video video2 = new Video("002", "Historia de la Ciudad", "Un recorrido histórico", 15.5);
        videoRepository.save(video1);
        videoRepository.save(video2);

        // Act
        List<Video> videos = videoService.getAllVideos();

        // Assert
        assertNotNull(videos, "La lista de videos no debería ser nula.");
        assertEquals(2, videos.size(), "La cantidad de videos retornada no es correcta.");
        assertTrue(videos.contains(video1), "El video1 no se encuentra en la lista.");
        assertTrue(videos.contains(video2), "El video2 no se encuentra en la lista.");
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        // Arrange
        videoRepository.findAll().clear(); // Asegurar que el repositorio esté vacío.

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.getAllVideos());
        assertEquals("Video no encontrado.", exception.getMessage(), "El mensaje de excepción no es el esperado.");
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
        Video foundVideo = videoService.findByTitle("Arte Moderno");

        // Assert
        assertNotNull(foundVideo);
        assertEquals("Arte Moderno", foundVideo.title());
    }

    @Test
    void findVideoByTitle_shouldThrowExceptionIfNotFound() {
        // Arrange
        videoRepository.findAll().clear();

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.findByTitle("Inexistente"));
        assertEquals("Video no encontrado: Inexistente", exception.getMessage());
    }
}
