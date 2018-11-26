package dao;

import model.Song;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {

    public static void addSong(Song song){
        String sql = "INSERT INTO song_library(artist, title, song_file, song_file_name, song_cover, lyrics)" +
                " VALUES(?,?,?,?,?,?)";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, song.getArtist());
            statement.setString(2, song.getTitle());
            statement.setBinaryStream(3, new FileInputStream(song.getSongFile()));
            statement.setString(4, song.getSongFileName());
            statement.setString(5, song.getSongCover());
            statement.setString(6, song.getLyrics());
            statement.executeUpdate();
        }catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static List<Song> getSongs(){
        String sql = "SELECT artist, title, song_cover, lyrics FROM song_library";
        List<Song> songs = new ArrayList<>();
        try(Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql)){
            while (rs.next()){
                Song song = new Song();
                song.setArtist(rs.getString("artist"));
                song.setTitle(rs.getString("title"));
                song.setSongCover(rs.getString("song_cover"));
                song.setLyrics(rs.getString("lyrics"));
                songs.add(song);
            }
            return songs;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteSong(String artist, String title){
        String sql = "DELETE FROM song_library WHERE artist=? AND title=?";
        try(Connection connection = DBUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, artist);
            statement.setString(2, title);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
