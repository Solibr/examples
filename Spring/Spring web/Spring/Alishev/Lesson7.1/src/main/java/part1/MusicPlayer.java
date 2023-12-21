package part1;

import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component("classicalMusicPlayer")
public class MusicPlayer {
    private Music music;

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void play() {
        System.out.println("Playing: " + music.getSong());
    }
}
