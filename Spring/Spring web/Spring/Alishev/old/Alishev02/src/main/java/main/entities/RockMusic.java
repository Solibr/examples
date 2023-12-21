package main.entities;

public class RockMusic implements Music {
    private String song = "Wind cries Mary";

    public static RockMusic factory() {
        RockMusic rockMusic = new RockMusic();
        rockMusic.song = "Thunderstuck";
        return rockMusic;
    }

    @Override
    public String getSong() {
        return song;
    }


}
