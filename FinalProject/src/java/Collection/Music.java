package Collection;

public class Music {

    private int UID;
    private String artist;
    private String album;

    public Music(int UID, String artist, String album) {
        this.UID = UID;
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
