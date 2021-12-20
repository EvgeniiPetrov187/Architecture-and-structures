package com.petrov.iterator;
//iterator
public class Main {
    public static void main(String[] args) {

        Track joker = new Track(10);
        PlayList playList = new PlayList();
        playList.addTrack(new Track(playList.next()));
        playList.addTrack(new Track(playList.next()));
        playList.addTrack(new Track(playList.next()));
        playList.addTrack(new Track(playList.next()));


        for (Track track : playList.getTracks()){
            System.out.println(track.getTrackNumber()+" plays");
        }

        System.out.println(playList.next()+ " new");
        System.out.println(playList.rewind()+ " old");
        playList.addTrack(joker);

        System.out.println();
        playList.removeTrack(joker);

        for (Track track : playList.getTracks()){
            System.out.println(track.getTrackNumber()+" plays");
        }
    }


}
