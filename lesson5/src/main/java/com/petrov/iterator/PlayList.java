package com.petrov.iterator;
//iterator
import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Track> tracks = new ArrayList<>();

    public List<Track> getTracks() {
        return tracks;
    }

    private int counter;

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        this.tracks.remove(track);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Track getCurrentTrack() {
        return this.tracks.get(counter);
    }

    public int playListLength() {
        return tracks.size();
    }

    public int next() {
        return this.counter++;
    }

    public int rewind() {
        return this.counter = 0;
    }
}
