package com.example.vamshi.covision.Data;

import android.graphics.Bitmap;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Vamshi on 6/24/2017.
 */

public class ImageCache extends HashMap<String, Bitmap> {

    private static ImageCache _instance_=null;

    public static ImageCache Instance(){
        if(_instance_!=null)
            return  _instance_;
        else
        {
            _instance_=new ImageCache();
            return  _instance_;
        }
    }

    public void AddToCache(String key,Bitmap image){
        if(!this.containsKey(key)) {
            this.put(key, image);
        }
    }

    public Bitmap GetFromCache(String key){
       return (this.containsKey(key)?this.get(key):null);
    }

    public boolean HasKey(String key)
    {
        return this.containsKey(key);
    }

}
