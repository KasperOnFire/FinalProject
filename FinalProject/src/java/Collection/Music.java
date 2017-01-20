package Collection;

public class Music {

    private String identifier;
    private String artist;
    private String album;

    public Music(String artist, String album) {
        this.artist = artist;
        this.album = album;
    }

    public Music(String identifier, String artist, String album) {
        this.identifier = identifier;
        this.artist = artist;
        this.album = album;
    }

    public String getIdentifier() {
        return identifier;
    }
    
    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
