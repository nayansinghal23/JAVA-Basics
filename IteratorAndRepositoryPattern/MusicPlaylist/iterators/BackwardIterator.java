package iterators;

import song.Song;

public class BackwardIterator extends Iteration {
    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Song next() {
        if(!hasNext() || index >= playlist.getList().size()) throw new IllegalArgumentException("Your playlist is completed.");
        Song song = playlist.getList().get(index);
        index = (playlist.getList().size() + index - 1) % playlist.getList().size();
        return song;
    }
}
