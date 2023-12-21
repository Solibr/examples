package main.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class RockMusic implements Music {

    private List<String> songList;


    public RockMusic() {
        songList = new ArrayList<>();
        songList.add("Thunderstuck");
        songList.add("Wind cries Mary");
        songList.add("Tier");
    }

    /*// TEST
    private static RockMusic instance;
    // TEST - нужно сделать метод фабричным. Проверим, можно ли сделать Scope = prototype, при этом реализовать в фабричном методе Singleton;
    private static RockMusic getThisShit() {
        if (instance == null) {
            instance = new RockMusic();
        }
        return instance;
    }
*/
    @Override
    public List<String> getSongList() {
        return songList;
    }


    /*public static RockMusic factory() {
        RockMusic rockMusic = new RockMusic();
        rockMusic.song = "Thunderstuck";
        return rockMusic;
    }*/

}
