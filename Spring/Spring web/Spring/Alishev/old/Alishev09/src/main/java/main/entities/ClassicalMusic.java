package main.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ClassicalMusic implements Music {

    private List<String> songList;

    public ClassicalMusic() {
        songList = new ArrayList<>();
        songList.add("Hungarian Rapsody");
        songList.add("Antonio Vivaldi - Winter");
        songList.add("Bethoven - Symphony #9");
    }

    @Override
    public List<String> getSongList() {
        return songList;
    }
}
