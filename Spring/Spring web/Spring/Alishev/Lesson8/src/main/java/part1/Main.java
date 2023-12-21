package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
