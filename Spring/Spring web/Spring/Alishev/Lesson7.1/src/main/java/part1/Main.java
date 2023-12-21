package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext*/ context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer player = context.getBean("rockMusicPlayer", MusicPlayer.class);
        player.play();

        context.close();
    }
}
