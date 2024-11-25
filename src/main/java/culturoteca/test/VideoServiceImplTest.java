package culturoteca.test;

import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;
import culturoteca.service.impl.VideoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideoServiceImplTest {

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoServiceImpl videoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks
    }

    // Test para getAllVideos con Mock
    @Test
    void when_getAllVideos_shouldReturnAllVideos() throws VideoNotFoundException {
        // Arrange
        Video video1 = new Video("001", "Cultura Ciudadana", "Un video sobre cultura", 10.0);
        Video video2 = new Video("002", "Historia de la Ciudad", "Un recorrido histórico", 15.5);
        when(videoRepository.findAll()).thenReturn(Arrays.asList(video1, video2));  // Mocking el repositorio

        // Act
        List<Video> videos = videoService.getAllVideos();

        // Assert
        assertNotNull(videos);
        assertEquals(2, videos.size());
        assertTrue(videos.contains(video1));
        assertTrue(videos.contains(video2));
    }

    @Test
    void when_getAllVideos_shouldThrowVideoNotFoundExceptionIfNoVideosFound() {
        // Arrange
        when(videoRepository.findAll()).thenReturn(Arrays.asList());  // Mocking repositorio vacío

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.getAllVideos());
        assertEquals("Video no encontrado.", exception.getMessage());
    }

    // Test para findByTitle con Mock
    @Test
    void when_findByTitle_shouldReturnVideo() throws VideoNotFoundException {
        // Arrange
        Video video = new Video("003", "Arte Moderno", "Un video sobre arte", 12.0);
        when(videoRepository.findTitle("Arte Moderno")).thenReturn(Arrays.asList(video));  // Mocking repositorio

        // Act
        Video foundVideo = videoService.findByTitle("Arte Moderno");

        // Assert
        assertNotNull(foundVideo);
        assertEquals("Arte Moderno", foundVideo.title());
    }

    @Test
    void when_findByTitle_shouldThrowVideoNotFoundExceptionIfNotFound() {
        // Arrange
        when(videoRepository.findTitle("Inexistente")).thenReturn(Arrays.asList());  // Mocking repositorio vacío

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.findByTitle("Inexistente"));
        assertEquals("Video no encontrado: Inexistente", exception.getMessage());
    }

    // Test para findByDuration con Mock
    @Test
    void when_findByDuration_shouldReturnVideos() throws VideoNotFoundException {
        // Arrange
        Video video1 = new Video("001", "Cultura Ciudadana", "Un video sobre cultura", 10.0);
        Video video2 = new Video("002", "Historia de la Ciudad", "Un recorrido histórico", 15.5);
        when(videoRepository.findVideosByDuration(5.0, 20.0)).thenReturn(Arrays.asList(video1, video2));  // Mocking repositorio

        // Act
        List<Video> videos = videoService.findByDuration(5.0, 20.0);

        // Assert
        assertNotNull(videos);
        assertEquals(2, videos.size());
        assertTrue(videos.contains(video1));
        assertTrue(videos.contains(video2));
    }

    @Test
    void when_findByDuration_shouldThrowVideoNotFoundExceptionIfNoVideosFound() {
        // Arrange
        when(videoRepository.findVideosByDuration(5.0, 20.0)).thenReturn(Arrays.asList());  // Mocking repositorio vacío

        // Act & Assert
        Exception exception = assertThrows(VideoNotFoundException.class, () -> videoService.findByDuration(5.0, 20.0));
        assertEquals("Video no encontrado.", exception.getMessage());
    }
}
