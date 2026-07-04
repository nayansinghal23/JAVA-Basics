package iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import song.Song;

public class ShuffleIterator extends Iteration {
    private final List<Song> shuffledSongs;

    public ShuffleIterator() {
        shuffledSongs = new ArrayList<>(playlist.getList()); // deep copy
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public Song next() {
        if (!hasNext()) throw new IllegalArgumentException("Playlist completed.");
        return shuffledSongs.get(index++);
    }
}
