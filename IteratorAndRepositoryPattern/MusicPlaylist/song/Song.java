package song;

public class Song {
    private final int id;
    private final String title;
    private final int artist;
    private final int duration;

    public Song(SongBuilder builder) {
        this.id = builder.getId();
        this.title = builder.getTitle();
        this.artist = builder.getArtist();
        this.duration = builder.getDuration();
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getArtist() {
        return this.artist;
    }

    public int getDuration() {
        return this.duration;
    }
}
