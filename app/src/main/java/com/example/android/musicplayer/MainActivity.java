package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;

import java.util.ArrayList;
import android.widget.MediaController.MediaPlayerControl;

public class MainActivity extends AppCompatActivity{

    //to avoid hardcode and miss-type
    static final String ARTIST = "Artist";
    static final String TITLE = "Title";
    static final String ALBUM = "Album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an ArrayList of words with 3 input arguments (Image Resource ID, Title, Artist Name)
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_1), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_2), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_3), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_4), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_5), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_6), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_7), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_8), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_9), R.drawable.jason_derulo_album));
        songs.add(new Song(getString(R.string.artist_name1), getString(R.string.song1_10), R.drawable.jason_derulo_album));

        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_1), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_2), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_3), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_4), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_5), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_6), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_7), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_8), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_9), R.drawable.adam_lambert_album));
        songs.add(new Song(getString(R.string.artist_name2), getString(R.string.song2_10), R.drawable.adam_lambert_album));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s.
        // The adapter knows how to create list items for each item in the list.
        com.example.android.musicplayer.SongAdapter adapter = new com.example.android.musicplayer.SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_main.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // create click listener for the items shown on screen
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected/clicked item position
                Song selectedItem = (Song) parent.getItemAtPosition(position);

                //create a new Intent which will open up a new layout in the app
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra(TITLE, selectedItem.getSongTitle());
                intent.putExtra(ARTIST, selectedItem.getArtistName());
                intent.putExtra(ALBUM, selectedItem.getAlbumIcon());
                startActivity(intent);
            }
        });
    }
}
