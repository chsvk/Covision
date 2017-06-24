package com.example.vamshi.covision.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.example.vamshi.covision.Data.ImageCache;
import com.example.vamshi.covision.Data.TopTrack;
import com.example.vamshi.covision.ImageDownloadTask;
import com.example.vamshi.covision.R;

import java.awt.font.TextAttribute;
import java.util.List;

/**
 * Created by Vamshi on 6/24/2017.
 */
@GlideModule
public class GridViewAdapter extends BaseAdapter {

    private List<TopTrack> tracks;
    private Context context;
    private LayoutInflater inflater;
    private ImageCache imageCache;


    public GridViewAdapter(List<TopTrack> tracks, Context context) {
        this.tracks = tracks;
        this.context = context;
        imageCache=ImageCache.Instance();
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        tracks.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;

        if(convertView==null){
            inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.single_item,null);
        }

        ImageView myImageView = (ImageView)gridView.findViewById(R.id.myImageView);
        TextView temp = (TextView)gridView.findViewById(R.id.temptext);
        TopTrack tempObject = tracks.get(position);
        Log.i("IMAHE LNK", tempObject.getImageUrl());

        Glide.with(context).load(tempObject.getImageUrl().trim()).into(myImageView);
        String song_name=tempObject.getSongName();
//        if(imageCache.HasKey(song_name))
//            myImageView.setImageBitmap(imageCache.GetFromCache(song_name));
//        else
//        {
//            new ImageDownloadTask(myImageView,imageCache,song_name).execute(tempObject.getImageUrl());
//        }
        temp.setText(song_name);

        return gridView;
    }
}
