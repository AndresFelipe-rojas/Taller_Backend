package culturoteca.repository;

import culturoteca.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTitle(String title);
    List<Video> findByDurationBetween(Double fromDuration, Double toDuration);
}