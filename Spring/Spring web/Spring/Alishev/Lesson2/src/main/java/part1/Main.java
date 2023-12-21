package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Music music = context.getBean("music", Music.class);
        MusicPlayer player = new MusicPlayer(music);
        player.play();

        context.close();
    }
}
