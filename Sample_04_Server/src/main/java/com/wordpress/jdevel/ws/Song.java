package com.wordpress.jdevel.ws;

import java.io.Serializable;

public class Song implements Serializable {
    String fileName;
    String artist;
    int size;

    public Song() {
    }

    public Song(String fileName, String artist, int size) {

        this.fileName = fileName;

        this.artist = artist;

        this.size = size;
    }

    public String getArtist() {

        return artist;
    }

    public void setArtist(String artist) {

        this.artist = artist;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }

    public int getSize() {

        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }
}

