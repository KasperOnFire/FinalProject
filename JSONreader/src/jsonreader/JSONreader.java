package jsonreader;

import org.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Tjalfe
 */
public class JSONreader {
    
    
    
    public String getJSON(String link){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        
        String res = "";
        
        try {
            url = new URL(link);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                res += line;
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return res;
    }
    public void soutJSON(String link){
        JSONObject obj = new JSONObject(getJSON(link));
        obj.getJSONObject("track").getString("name");
        System.out.println(obj.getJSONObject("track").getJSONObject("artist").getString("name"));
    }
        //System.out.println(obj.getJSONObject("track").get("artist"));
}