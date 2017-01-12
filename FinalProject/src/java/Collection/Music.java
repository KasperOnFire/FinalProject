package Collection;

public class Music {

    private int UID;
    private String artist;
    private String album;
    private String image;
    private int year;
    private String song;
    private int time;

    public Music(int UID, String artist, String album, String image, int year, String song, int time) {
        this.UID = UID;
        this.artist = artist;
        this.album = album;
        this.image = image;
        this.year = year;
        this.song = song;
        this.time = time;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }

    public String getSong() {
        return song;
    }

    public int getTime() {
        return time;
    }
    
    
    
}
