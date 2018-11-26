package dao;

import com.beaglebuddy.mp3.MP3;
import com.google.gson.Gson;
import model.AlbumCover;
import model.Lyrics;
import model.Song;

import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Helper {

    private MP3 musicFile;
    private File file;
    private Scanner scanner;

    EntityManagerFactory emf;

    public Helper() {
    }

    public Helper(File file) throws IOException {
        this.musicFile = new MP3(file);
        this.file = file;
    }

    public String getArtist(){
        return musicFile.getBand();
    }



    private String encode(String par){
        scanner = new Scanner(par);
        String s="";
        while (scanner.hasNext()){
            s += scanner.next();
            if (scanner.hasNext()) s+= "%20";
        }
        return s;
    }

    public String getTitle(){
        return musicFile.getTitle();
    }

    public String getLyrics() {
        try {
            URL url = new URL("https://api.lyrics.ovh/v1/" + encode(getArtist() + "/" + encode(getTitle())));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200)
                throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Lyrics lyrics = new Gson().fromJson(br, Lyrics.class);
            return lyrics.getLyrics();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getCover() {
        try {
            URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key=cec76490d5f538259b62a0fb22c9f3fe" +
                    "&artist=" + encode(getArtist()) + "&track=" + encode(getTitle()) + "&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200)
                throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            AlbumCover song = new Gson().fromJson(br, AlbumCover.class);
            String imgUrl = song.getTrack().getAlbum().getImage().get(2).getText();
            return imgUrl;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addSong(){
        Song song = new Song();
        song.setArtist(getArtist());
        song.setTitle(getTitle());
        song.setLyrics(getLyrics());
        song.setSongCover(getCover());
        song.setSongFile(file);
        song.setSongFileName(file.getName());
        DBAccess.addSong(song);
    }



}
