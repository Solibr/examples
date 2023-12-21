package main.entities;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

public class MusicPlayer {

    private Map<MusicType, List<String>> musicLibrary;
    private Random random = new Random();

    @Value("${musicPlayer.name}") private String name;
    @Value("${musicPlayer.volume}") private int volume;

    public MusicPlayer(Map<MusicType, List<String>> musicLibrary) {
        this.musicLibrary = musicLibrary;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void playMusic() {
        MusicType randomMusicType = MusicType.values()[random.nextInt(MusicType.values().length)];
        List<String> songList = musicLibrary.get(randomMusicType);
        String songName = songList.get(random.nextInt(songList.size()));
        System.out.println(songName);
    }
}
