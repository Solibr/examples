package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        player.play();

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);


        context.close();
    }
}
