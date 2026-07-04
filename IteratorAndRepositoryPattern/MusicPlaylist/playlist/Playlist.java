package playlist;

import java.util.ArrayList;
import java.util.List;

import song.Song;
import song.SongBuilder;

public class Playlist {
    private List<Song> list;

    public Playlist() {
        list = new ArrayList<>();
        seedSongs();
    }

    private void seedSongs() {
        add(new SongBuilder(1, "Song-1", 1, 20).build());
        add(new SongBuilder(2, "Song-2", 1, 30).build());
        add(new SongBuilder(3, "Song-3", 1, 40).build());
        add(new SongBuilder(4, "Song-4", 1, 50).build());
        add(new SongBuilder(5, "Song-5", 1, 10).build());
    }

    public void add(Song song) {
        list.add(song);
    }

    public void remove(Song song) {
        List<Song> filteredList = new ArrayList<>();
        for(Song s: list) {
            if(s.getId() != song.getId()) filteredList.add(s);
        }
        list = filteredList;
    }

    public List<Song> getList() {
        return list;
    }
}
