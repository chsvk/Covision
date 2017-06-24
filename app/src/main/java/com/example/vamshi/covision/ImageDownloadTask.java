package com.example.vamshi.covision;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.vamshi.covision.Data.ImageCache;

import java.io.InputStream;

/**
 * Created by Bharath_Chinnam on 04/06/2017.
 */

public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;
    Bitmap imageResult;
    ImageCache imageCache;
    String imageKey="";

    public ImageDownloadTask(ImageView bmImage,ImageCache cache,String imageKey) {
        this.bmImage = bmImage;
        this.imageCache=cache;
        this.imageKey=imageKey;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        imageResult=result;
        bmImage.setImageBitmap(result);
        imageCache.AddToCache(imageKey,result);
    }

    public Bitmap GetImage()
    {
        return imageResult;
    }
}