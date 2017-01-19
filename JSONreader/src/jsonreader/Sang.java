package jsonreader;

public class Sang {

    private int cdNumber;
    private int duration;
    private String name;

    public Sang(int cdNumber, int duration, String name) {
        this.cdNumber = cdNumber;
        this.duration = duration;
        this.name = name;
    }

    public int getCdNumber() {
        return cdNumber;
    }

    public String getDuration() {
        String res = "";
        if(duration > 3600){
            res += duration/3600+":";
        }
        if(duration > 60){
            res += duration%3600/60+":";
        }
        if(duration%3600%60 >= 10){
            res += duration%3600%60+"";
        }else{ 
            res += "0"+duration%3600%60;
        }
        
        return res;
    }

    public String getName() {
        return name;
    }  
}
