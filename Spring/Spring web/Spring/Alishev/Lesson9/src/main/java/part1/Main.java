package part1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {

        // #new - теперь указываем спрингу, что конфигурация находится в java классе, а не xml файле
        context = new AnnotationConfigApplicationContext(Config.class);

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println();
        player.play();
        System.out.println();

        System.out.println();
        System.out.println("Player volume: " + player.getVolume());
        System.out.println("Player name: " + player.getName());

        System.out.println("Favourite music: " + player.favouriteMusic.getClass());

        context.close();
    }
}
