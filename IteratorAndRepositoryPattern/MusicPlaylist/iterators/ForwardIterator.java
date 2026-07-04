package iterators;
import song.Song;

public class ForwardIterator extends Iteration {
    @Override
    public boolean hasNext() {
        return index < playlist.getList().size();
    }

    @Override
    public Song next() {
        if(!hasNext() || index < 0) throw new IllegalArgumentException("Your playlist is completed.");
        Song song = playlist.getList().get(index);
        index = (index + 1) % playlist.getList().size();
        return song;
    }
}
