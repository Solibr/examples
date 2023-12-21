package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        player.play();

        MusicPlayer player2 = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(player==player2);

        System.out.println("\n" + player.getName() + "\n" + player.getVolume());

        context.close();
    }
}
