package main;

import main.entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext("main.config");

        //Music music = context.getBean("musicBean", Music.class);

        MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
        player.playMusic();

        System.out.println(player.getName() + "   " + player.getVolume());

        // TEST
        System.out.println("Test");
        RockMusic rock1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rock2 = context.getBean("rockMusic", RockMusic.class);
        System.out.println("Same objects: " + (rock1 == rock2));
    }



}
