package culturoteca.repository.impl;
import java.util.ArrayList;
import java.util.List;

import culturoteca.model.Video;
import culturoteca.repository.VideoRepository;

public class ImpVideoRepository implements VideoRepository {

    private final List<Video> videos;

    public ImpVideoRepository() {
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> findAll() {
        return videos;
    }

    @Override
    public Video save(Video video) {
        this.videos.add( video );
        return video;
    }

    @Override
    public List<Video> findTitle(String title) {
        List<Video> filteredVideos = null;
        for ( Video video : videos ) {
            if(title.equals( video.title() )){
                if(filteredVideos == null){
                    filteredVideos = new ArrayList<Video>();
                }
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }

    @Override
    public List<Video> findVideosByDuration(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<Video>();
        for ( Video video : videos ) {
            if(video.duration()> fromDuration && video.duration()< toDuration){
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }
}
