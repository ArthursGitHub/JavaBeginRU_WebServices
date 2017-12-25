package com.wordpress.jdevel.ws;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Music")
public class Music {
    private static final File FOLDER = new File("D:/TEMP/SONGS");

    @WebMethod(operationName = "listSongs")
    public Song[] listSongs(@WebParam(name = "artist") String artist) {
        List<Song> songs = new ArrayList<Song>();
        System.out.println("ARTIST: " + artist);
        if (artist != null) {
            File folder = new File(FOLDER, artist);
            if (folder.exists() && folder.isDirectory()) {
                File[] listFiles = folder.listFiles(new FilenameFilter() {


                    public boolean accept(File dir, String name) {
                        return name.toUpperCase().endsWith(".MP3");
                    }


                });

                for (File file : listFiles) {
                    String fileName = file.getName();
                    String author = file.getParentFile().getName();
                    int size = (int) (file.length() / 1048576); //Megabytes
                    Song song = new Song(fileName, author, size);
                    songs.add(song);
                }
            }
        }
        return songs.toArray(new Song[songs.size()]);
    }

    @WebMethod(operationName = "listArtists")
    public String[] listArtists() {
        File[] folders = getFolders(FOLDER);
        List<String> artists = new ArrayList<String>(folders.length);
        for (File folder : folders) {
            artists.add(folder.getName());
        }
        return artists.toArray(new String[artists.size()]);
    }

    private File[] getFolders(File parent) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        File[] folders = parent.listFiles(filter);
        return folders;
    }

    public static void main(String[] args) {
        Music listFiles = new Music();
        String[] artists = listFiles.listArtists();
        System.out.println("Artists: " + artists);
        for (String artist : artists) {
            Song[] listSongs = listFiles.listSongs(artist);
            for (Song song : listSongs) {
                System.out.println(song.getArtist() + " : " + song.getFileName() + " : " + song.getSize() + "MB");
            }
        }
    }
}
