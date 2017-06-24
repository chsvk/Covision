package com.example.vamshi.covision.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vamshi.covision.R;

public class DetailsActivity extends AppCompatActivity {

    TextView song_name;
    TextView listens;
    TextView artist_name;
    Button record_button;
    Button play_button;
    ImageView song_image;
    ListView covers_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        song_name = (TextView)findViewById(R.id.song_name);
        listens = (TextView)findViewById(R.id.listens);
        artist_name = (TextView)findViewById(R.id.artist_name);
        record_button = (Button)findViewById(R.id.record_button);
        play_button = (Button)findViewById(R.id.play_button);
        song_image = (ImageView)findViewById(R.id.song_image);
        covers_list = (ListView) findViewById(R.id.covers_list);
        Intent in = getIntent();
        song_name.setText("Song:- " + in.getStringExtra("songName"));
        listens.setText("Played " + in.getStringExtra("listens") + "times");
        artist_name.setText("Artist:- " + in.getStringExtra("artistName"));
        Glide.with(this).load(in.getStringExtra("songImage").trim()).into(song_image);
        record_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "Clicked Record", Toast.LENGTH_SHORT).show();
            }
        });

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "Clicked Play", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
