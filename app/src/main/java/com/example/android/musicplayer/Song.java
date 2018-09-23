package com.example.android.musicplayer;

import java.util.Comparator;

/**
 * {@link Song} represents a list of songs that the user wants to listen.
 * It contains a song title and the artist name for that song.
 **/

public class Song {
    private String mArtistName; //state-Artist name for the word
    private String mSongTitle; //state-Song title for the word
    private int mAlbumIcon; //Image resource ID for the song

    //constructor
    public Song (String artistName, String songTitle, int albumIcon){
        mArtistName = artistName;
        mSongTitle = songTitle;
        mAlbumIcon = albumIcon;
    }

    public String getSongTitle(){return mSongTitle;} //method-get the song title of the word.
    public String getArtistName(){return mArtistName;} //method-get the artist name of the word.
    public int getAlbumIcon() {return mAlbumIcon;} //method-get the album image(Res. ID) for the song
}
