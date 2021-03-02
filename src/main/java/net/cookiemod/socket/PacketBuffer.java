package net.cookiemod.socket;


import com.google.gson.Gson;

public class PacketBuffer {

    private int Cookies;
    private int Villagers;

    public PacketBuffer(){
        //no-args constructor for gson
    }

    public void addCookies(int cookies) {
        Cookies += cookies;
    }

    public void addVillagers(int villagers) {
        Villagers += villagers;
    }

    public String getJson(){
        return new Gson().toJson(this);
    }

    public void reset(){
        Cookies = 0;
        Villagers = 0;
    }

}
