package com.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

public class ParseMusicLibraryJson {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            File file = new File("src/com/json/music-library.json");
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray albumsArray = (JSONArray) jsonObject.get("albums");
            System.out.println("Albums:");
            for (int i = 0; i < albumsArray.size(); i++) {
                String id = (String)((JSONObject)albumsArray.get(i)).get("id");
                String name = (String)((JSONObject)albumsArray.get(i)).get("name");
                System.out.println("Album ID: " + id);
                System.out.println("Album name: " + name);
            }

            System.out.println("---------------------");

            JSONArray artistsArray = (JSONArray) jsonObject.get("artists");
            System.out.println("Artists:");
            for (int i = 0; i < artistsArray.size(); i++) {
                String id = (String)((JSONObject)artistsArray.get(i)).get("id");
                String name = (String)((JSONObject)artistsArray.get(i)).get("name");
                System.out.println("Artist ID: " + id);
                System.out.println("Artist name: " + name);
            }

            System.out.println("---------------------");

            JSONArray songsArray = (JSONArray) jsonObject.get("songs");
            System.out.println("Songs:");
            for (int i = 0; i < songsArray.size(); i++) {
                String idSong = (String)((JSONObject)songsArray.get(i)).get("id");
                String title = (String)((JSONObject)songsArray.get(i)).get("title");
                String idArtist = (String)((JSONObject)((JSONObject)songsArray.get(i)).get("artist")).get("id");
                String nameArtist = (String)((JSONObject)((JSONObject)songsArray.get(i)).get("artist")).get("name");
                String idAlbum = (String)((JSONObject)((JSONObject)songsArray.get(i)).get("album")).get("id");
                String nameAlbum = (String)((JSONObject)((JSONObject)songsArray.get(i)).get("album")).get("name");


                System.out.println("Song ID: " + idSong);
                System.out.println("Song name: " + title);
                System.out.println("Artist ID: " + idArtist);
                System.out.println("Artist name: " + nameArtist);
                System.out.println("Album ID: " + idAlbum);
                System.out.println("Album name: " + nameAlbum);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
