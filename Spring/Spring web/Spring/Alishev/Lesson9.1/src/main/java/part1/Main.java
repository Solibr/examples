package part1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(Config.class);

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println();
        player.play();
        System.out.println();

        System.out.println();
        System.out.println("Player volume: " + player.getVolume());
        System.out.println("Player name: " + player.getName());

        System.out.println(player == context.getBean("musicPlayer", MusicPlayer.class));

        context.close();
    }
}
