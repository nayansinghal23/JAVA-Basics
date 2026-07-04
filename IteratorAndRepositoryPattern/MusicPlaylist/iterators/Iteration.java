package iterators;

import playlist.Playlist;
import song.Song;

public abstract class Iteration implements Iterator<Song> {
    protected final Playlist playlist = new Playlist();
    protected int index = 0;
}
