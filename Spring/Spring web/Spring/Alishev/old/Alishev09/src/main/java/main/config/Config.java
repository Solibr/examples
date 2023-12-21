package main.config;

import main.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class Config {

    @Bean//("musicPlayer")
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicLibrary());
    }

    @Bean/*("musicLibrary")*/
    public Map<MusicType, List<String>> musicLibrary() {
        Map<MusicType, List<String>> musicLibrary = new TreeMap<>();
        musicLibrary.put(MusicType.CLASSICAL,   classicalMusic().getSongList());
        musicLibrary.put(MusicType.ROCK,        rockMusic().getSongList());
        musicLibrary.put(MusicType.ELECTRO,     electroMusic().getSongList());
        return musicLibrary;
    }

    @Bean
    public Music classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public Music rockMusic() {
        return new RockMusic();
    }

    @Bean
    public Music electroMusic() {
        return new ElectroMusic();
    }

}
