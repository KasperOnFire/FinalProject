package jsonreader;

import java.util.ArrayList;

/**
 *
 * @author Tjalfe
 */
public class JSONmain {

    public static void main(String[] args) {
        JSONreader JSON = new JSONreader();
        ArrayList<Sang> temp = JSON.getAlbum("the xx","xx");
        for (Sang sang : temp) {
            System.out.println("");
            System.out.println("CDNumber: "+sang.getCdNumber());
            System.out.println("Name: "+sang.getName());
            System.out.println("Duration: "+sang.getDuration());
        }
    }
}
