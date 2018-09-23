package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicplayer.R;
import com.example.android.musicplayer.Song;

import java.util.ArrayList;
import java.util.List;

//superclass= ArrayAdapter, subclass= SongAdapter
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        //resource ID= 0
        //as this is not a single text . The adapter is not using the second argument
        //so, it can be any value. Here, I used 0.
        super(context, 0, songs);}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the Song object located at this position in the list
        Song currentSong = getItem(position);

        //Finding the ImageView and the 2 TextViews in the list_item layout
        TextView songTitleTextView = listItemView.findViewById(R.id.song_title_text_view);
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name_text_view);
        ImageView albumImageView = listItemView.findViewById(R.id.album_icon_image);

        songTitleTextView.setText(currentSong.getSongTitle());
        artistNameTextView.setText(currentSong.getArtistName());
        albumImageView.setImageResource(currentSong.getAlbumIcon());

        return listItemView;
    }
}
