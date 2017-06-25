package com.example.vamshi.covision.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.vamshi.covision.Data.Fan;
import com.example.vamshi.covision.R;

import java.util.List;



/**
 * Created by Vamshi on 6/20/2017.
 */

public class CustomListViewAdapter extends ArrayAdapter<Fan> {

    private List<Fan> mFans;
    private Context context;


    public CustomListViewAdapter(@NonNull Context context, @NonNull List<Fan> objects) {
        super(context, R.layout.single_item_list_view, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.single_item_list_view, parent, false);
        String title = getItem(position).getFan_name();
        TextView fan_name = (TextView) customView.findViewById(R.id.fan_name);
        TextView listens = (TextView) customView.findViewById(R.id.listens);
        ImageView fan_image = (ImageView) customView.findViewById(R.id.fan_image);
        fan_name.setText(title);
        listens.setText(getItem(position).getListens());
//        Glide.with(context).load(getItem(position).getFan_image().trim()).into(fan_image);
//        final FloatingActionButton fab = (FloatingActionButton)customView.findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                fab.setImageResource(R.drawable.fav_full);
//                Toast.makeText(context, "Fav'd this cover!", Toast.LENGTH_SHORT).show();
//
//            }
//        });
        return customView;
    }
}