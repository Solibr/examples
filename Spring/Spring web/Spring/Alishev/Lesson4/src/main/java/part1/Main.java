package part1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MusicPlayer player = context.getBean("rockMusicPlayer", MusicPlayer.class);
        player.play();
        System.out.println(player.getName() + "\n" + player.getVolume());


        context.close();
    }
}
