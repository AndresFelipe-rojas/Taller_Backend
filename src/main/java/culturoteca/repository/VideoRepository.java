package culturoteca.repository;
import java.util.List;
import culturoteca.model.Video;

public interface VideoRepository {
    List<Video> findAll();

    Video save(Video save);

    List<Video> findTitle(String title);

    List<Video> findVideosByDuration(Double fromDuration, Double toDuration);
}
