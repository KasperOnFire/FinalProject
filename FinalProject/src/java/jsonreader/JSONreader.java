package jsonreader;

import JSON.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JSONreader {

    private String apiLink = "http://ws.audioscrobbler.com/2.0/";
    private String apiKey = "3a8d6a8d0cb4132cacd967e9b9bae016";

    private String getJSON(String artistName, String albumName) {
        String jsonLink = apiLink + "?method=album.getinfo&api_key=" + apiKey
                + "&artist=" + artistName.replaceAll(" ", "%20") + "&album=" + albumName.replaceAll(" ", "%20") + "&autocorrect[1]&format=json";
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        String json = "";

        try {
            url = new URL(jsonLink);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                json += line;
            }
        } catch (MalformedURLException mue) {
            System.out.println("ERROR JSONReader 1:");
            mue.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("ERROR JSONReader 2:");
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                System.out.println("ERROR JSONReader 3:");
                ioe.printStackTrace();
            }
        }
        return json;
    }

    public ArrayList<Sang> getAlbum(String artistName, String albumName) {
        ArrayList<Sang> album = new ArrayList();
        JSONObject obj = new JSONObject(getJSON(artistName, albumName));
        String tempJSON;
        Sang tempSang;
        int i = 0;
        try {
            while (true) {
                tempJSON = obj.getJSONObject("album").getJSONObject("tracks").getJSONArray("track").get(i).toString();
                JSONObject tempObj = new JSONObject(tempJSON);
                tempSang = new Sang(i + 1, Integer.parseInt(tempObj.getString("duration")), tempObj.getString("name"));
                album.add(tempSang);
                i++;
            }
        } catch (Exception e) {
            System.out.println("ERROR JSONReader 4:");
            e.printStackTrace();
        }
        return album;
    }
}
