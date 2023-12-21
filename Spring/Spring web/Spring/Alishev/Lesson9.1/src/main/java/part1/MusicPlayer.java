package part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// #new
public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();

    // #new
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    // #new
    // Использование аннотации Qualifier, чтобы избежать неопределённости
    public Music favouriteMusic;

    public MusicPlayer() {
        System.out.println("Constructor was invoked");
    }

    public MusicPlayer(MusicList list) {
        musicList = list.getMusicList();
    }

    public static MusicPlayer getMusicPlayer() {
        System.out.println("Factory-method was invoked");
        return new MusicPlayer();
    }

    // #new - использование аннотаций PostConstruct и PreDestroy требует наличия пакета javax.annotation
    public void init() {
        System.out.println("Music Player. Init method invoked");
    }

    public void destroy () {
        System.out.println("Music Player. Destroy method invoked");
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
