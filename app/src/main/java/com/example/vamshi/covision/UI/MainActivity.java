package com.example.vamshi.covision.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.vamshi.covision.Adapters.GridViewAdapter;
import com.example.vamshi.covision.Data.DownloadData;
import com.example.vamshi.covision.Data.TopTrack;
import com.example.vamshi.covision.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

//    public static Realm realm;
    public static List<TopTrack> fTracks;
    public static GridView myGridView;
    public static GridViewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fTracks = new ArrayList<>();
        myGridView = (GridView) findViewById(R.id.myGridView);

        myAdapter = new GridViewAdapter(fTracks,this);
//        Realm.init(this);
//        realm = Realm.getDefaultInstance();
        DownloadData ne = new DownloadData();
        ne.execute("url");
        myGridView.setAdapter(myAdapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(MainActivity.this, DetailsActivity.class);
                in.putExtra("songName", fTracks.get(position).getSongName());
                in.putExtra("listens", fTracks.get(position).getListeners());
                in.putExtra("artistName", fTracks.get(position).getArtistName());
                in.putExtra("songImage", fTracks.get(position).getImageUrl());
                startActivity(in);
            }
        });

    }

    @Override
    protected void onDestroy() {
//        realm.close();
        super.onDestroy();
    }

    public static void load(){
        myGridView.setAdapter(myAdapter);
    }

//    public static void load_data(){
//
//        RealmResults<TopTrack> tracks = realm.where(TopTrack.class).findAllAsync();
//        tracks.load();
//        for(TopTrack trac:tracks){
//            TopTrack temp = new TopTrack(trac.getSongName(),
//                    trac.getListeners(), trac.getUrl(),
//                    trac.getArtistName(), trac.getSongUrl(),
//                    trac.getImageUrl());
//            fTracks.add(temp);
//        }
//        myGridView.setAdapter(myAdapter);
//    }
}
