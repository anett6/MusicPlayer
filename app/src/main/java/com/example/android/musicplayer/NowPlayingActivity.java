package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    //to avoid hardcoding and miss-type
    static final String ARTIST = "Artist";
    static final String TITLE = "Title";
    static final String ALBUM = "Album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Getting extra Strings: song TITLE, ARTIST name and integer: ALBUM Resource ID from MainActivity
        Intent mIntent = getIntent();
        String artistName = mIntent.getStringExtra(ARTIST);
        String songTitle = mIntent.getStringExtra(TITLE);
        int albumIcon = mIntent.getIntExtra(ALBUM, 0);

        //Find the 2 TextViews and ImageView in the activity_now_playing layout.
        ImageView nowPlayingAlbumImage = findViewById(R.id.now_paying_album_image);
        TextView nowPlayingSongTitle = findViewById(R.id.now_paying_song_title);
        TextView nowPlayingArtistName = findViewById(R.id.now_playing_artist_name);

        nowPlayingAlbumImage.setImageResource(albumIcon);
        nowPlayingSongTitle.setText(songTitle);
        nowPlayingArtistName.setText(artistName);
        }
    }
