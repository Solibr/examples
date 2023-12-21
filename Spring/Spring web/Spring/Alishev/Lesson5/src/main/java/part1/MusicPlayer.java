package part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

    public MusicPlayer() {}

    public MusicPlayer(List<Music> list) {
        musicList = list;
    }

    public void setMusic(List<Music> list) {
        musicList = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void play() {
        List<Music> tempList = new ArrayList<>(musicList);
        Random rnd = new Random();
        while (tempList.size() > 0) {
            int index = rnd.nextInt(tempList.size());
            System.out.println(tempList.get(index).getSong());
            tempList.remove(index);
        }
    }
}
