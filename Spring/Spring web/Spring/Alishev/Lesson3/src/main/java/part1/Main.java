package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*Music music = context.getBean("rock", Music.class);
        MusicPlayer player = new MusicPlayer(music);*/

        // #new
        // Получаем объект MusicPlayer не вручную, а из контекста
        MusicPlayer player = context.getBean("rockMusicPlayer", MusicPlayer.class);
        player.play();

        context.close();
    }
}
