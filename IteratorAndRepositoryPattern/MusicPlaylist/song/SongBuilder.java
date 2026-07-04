package song;

public class SongBuilder {
    private final int id;
    private final String title;
    private final int artist;
    private final int duration;

    public SongBuilder(int id, String title, int artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
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

    public Song build() {
        return new Song(this);
    }
}
