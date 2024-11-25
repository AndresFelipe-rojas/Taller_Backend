package culturoteca.controllers;

import culturoteca.exception.DuracionNotValidException;
import culturoteca.exception.VideoNotFoundException;
import culturoteca.model.Video;
import culturoteca.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoServiceImpl videoService;

    @Autowired
    public VideoController(VideoServiceImpl videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/all")
    public List<Video> getAllVideos() throws VideoNotFoundException {
        return videoService.getAllVideos();
    }

    @GetMapping("/title/{title}")
    public Video getVideoByTitle(@PathVariable String title) throws VideoNotFoundException {
        return videoService.findByTitle(title);
    }

    @PostMapping("/add")
    public Video addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }

    @GetMapping("/duration")
    public List<Video> getVideosByDuration(@RequestParam Double fromDuration, @RequestParam Double toDuration) throws DuracionNotValidException {
        return videoService.findByDuration(fromDuration, toDuration);
    }
}
