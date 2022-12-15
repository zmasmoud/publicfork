package provider;

import data.Database;
import data.VideoDataEU;
import data.VideoDataUS;
import model.VideoFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation of a video file provider for Swengflix.
 * !!!!!!!!!!!!!!!!!!!!!!!
 * You CAN edit this file.
 * !!!!!!!!!!!!!!!!!!!!!!!
 */
public class SwengflixProvider implements VideoFileProvider {

    private final List<Database> dbs;
    private final HashMap<Integer, VideoFile> cache = new HashMap<>();
    /**
     * Creates a SwengflixProvider using the given databases.
     */
    public SwengflixProvider(Database... dbs) {
        this.dbs = Arrays.asList(dbs);
    }

    /**
     * Creates a SwengflixProvider using the default databases.
     */
    public SwengflixProvider() {
        // the EU database is geographically closer so its delay is lower
        this.dbs = Arrays.asList(
                new Database(VideoDataEU.allVideoData(), 3_000),
                new Database(VideoDataUS.allVideoData(), 5_000)
        );
    }

    @Override
    public CompletableFuture<VideoFile> getVideo(int uniqueID) {
        if(cache.containsKey(uniqueID)){
            return CompletableFuture.completedFuture(cache.get(uniqueID));
        }
        AtomicInteger evicted = new AtomicInteger();
        // TODO: We should enable querying of any of our databases (not just the EU DB)
        return dbs.get(0).getVideoFile(uniqueID).anyOf(dbs.get(1).getVideoFile(uniqueID)).
                thenApply(v -> {
                    if(cache.size() == 2){
                        cache.remove(evicted.get());
                        evicted.set(cache.keySet().stream().toList().get(0));
                    }
                    cache.put(uniqueID, (VideoFile)v);
                    if(cache.size() == 1) {
                        evicted.set(uniqueID);
                    }
                    return (VideoFile)v;
                });

    }
}
