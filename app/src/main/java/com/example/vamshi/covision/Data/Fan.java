package com.example.vamshi.covision.Data;

/**
 * Created by Vamshi on 6/25/2017.
 */

public class Fan {

     private String fan_name;
    private String fan_image;
    private String listens;

    public Fan(String fan_name, String fan_image, String listens) {
        this.fan_name = fan_name;
        this.fan_image = fan_image;
        this.listens = listens;
    }

    public String getFan_name() {
        return fan_name;
    }

    public void setFan_name(String fan_name) {
        this.fan_name = fan_name;
    }

    public String getFan_image() {
        return fan_image;
    }

    public void setFan_image(String fan_image) {
        this.fan_image = fan_image;
    }

    public String getListens() {
        return listens;
    }

    public void setListens(String listens) {
        this.listens = listens;
    }
}
