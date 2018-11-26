package model;

import java.io.File;

public class Song {
    private String artist;
    private String title;
    private File songFile;
    private String songFileName;
    private String songCover;
    private String lyrics;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getSongFile() {
        return songFile;
    }

    public void setSongFile(File songFile) {
        this.songFile = songFile;
    }


    public String getSongFileName() {
        return songFileName;
    }

    public void setSongFileName(String songFileName) {
        this.songFileName = songFileName;
    }


    public String getSongCover() {
        return songCover;
    }

    public void setSongCover(String songCover) {
        this.songCover = songCover;
    }


    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }


}
