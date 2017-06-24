package com.example.vamshi.covision.Data;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vamshi.covision.UI.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Vamshi on 6/24/2017.
 */

public class DownloadData extends AsyncTask {
    String result;
    //private Realm realm = Realm.getDefaultInstance();

    @Override
    protected Object doInBackground(Object[] params) {

        result = "";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=ea50b8271def892cb877d5983fc8ca3a&format=json").build();
        try {
            result = client.newCall(request).execute().body().string();
                JSONObject rootObject = new JSONObject(result);
Log.i("Result", result);
            JSONObject r = rootObject.getJSONObject("tracks");
            JSONArray rA = r.getJSONArray("track");
            Log.i("BREA", "STOPPED HERE");
            for(int i = 0 ; i< rA.length(); i++){
                JSONObject tempObject = rA.getJSONObject(i);
                String songName = tempObject.getString("name");
                String listeners = tempObject.getString("listeners");
                String songUrl = tempObject.getString("url");
                JSONObject artist = tempObject.getJSONObject("artist");
                String artistName = artist.getString("name");
                String artistUrl = artist.getString("url");
                JSONArray image = tempObject.getJSONArray("image");
                JSONObject link = image.getJSONObject(3);
                String imageLink = link.getString("#text");
                Log.i("SONGNAME", songName);
                storeData(songName, listeners, songUrl, artistName, artistUrl, imageLink);
                //Log.i("SONGNAME", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

            }

        } catch (Exception e) {

            Log.i("EXCEPTOPN", e.getMessage());
        }
        return  null;
    }

    private void storeData(final String songName, final String listeners, final String songUrl, final String artistName, final String artistUrl, final String imageLink) {

        //realm.beginTransaction();
        //realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
                TopTrack track = new TopTrack(songName, listeners, songUrl, artistName, artistUrl, imageLink);
                MainActivity.fTracks.add(track);
//                track.setArtistName(artistName);
//                track.setImageUrl(imageLink);
//                track.setListeners(listeners);
//                track.setSongName(songName);
//                track.setSongUrl(songUrl);
//                track.setUrl(artistUrl);
//            }
//        });
//        realm.commitTransaction();
    }

    @Override
    protected void onPostExecute(Object o) {

//        MainActivity.myGridView.setAdapter(MainActivity.myAdapter);
        MainActivity.load();

        super.onPostExecute(o);
    }
}
