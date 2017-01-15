package jsonreader;

/**
 *
 * @author Tjalfe
 */
public class JSONmain {

    public static void main(String[] args) {
        JSONreader JSON = new JSONreader();
        JSON.soutJSON("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=3a8d6a8d0cb4132cacd967e9b9bae016&artist=cher&track=believe&format=json");
    }
}
