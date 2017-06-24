package com.example.vamshi.covision.Data;

import io.realm.RealmObject;

/**
 * Created by Vamshi on 6/24/2017.
 */

public class TopTrack {

    private String songName;
    private String listeners;
    private String url;
    private String artistName;
    private String songUrl;
    private String imageUrl;


    public TopTrack(String songName, String listeners, String url, String artistName, String songUrl, String imageUrl) {
        this.songName = songName;
        this.listeners = listeners;
        this.url = url;
        this.artistName = artistName;
        this.songUrl = songUrl;
        this.imageUrl = imageUrl;
    }

    public TopTrack(){

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
