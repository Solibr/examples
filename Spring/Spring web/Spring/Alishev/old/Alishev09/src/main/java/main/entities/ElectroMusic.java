package main.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ElectroMusic implements Music{

    private List<String> songList;

    public ElectroMusic() {
        songList = new ArrayList<>();
        songList.add("Owl Vision - Jockz");
        songList.add("GHOST DATA - Beyond Eternity");
        songList.add("Geoxor - Neon Eyes");
    }


    @Override
    public List<String> getSongList() {
        return songList;
    }
}
