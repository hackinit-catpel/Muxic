package com.example.kolibreath.muxics.Classes;

/**
 * Created by kolibreath on 17-4-24.
 */

public class Music {
    public String singer;
    public String name;

    public Music(String singer, String name){
        this.singer = singer;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String getSinger(){
        return singer;
    }
}
