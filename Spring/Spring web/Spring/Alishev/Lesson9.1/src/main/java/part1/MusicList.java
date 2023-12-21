package part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MusicList {
    private List<Music> musicList = new ArrayList<>();

    // #new
    // Использование Qualifier в списке параметров
    public MusicList(Music music1,
                     Music music2,
                     Music music3) {
        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);

//      Ошибка
//        musicList.add(Main.context.getBean("classicalMusic", Music.class));
//        musicList.add(Main.context.getBean("rockMusic", Music.class));
//        musicList.add(Main.context.getBean("electroMusic", Music.class));

//      Рабочий пример.
//        musicList.add(new ClassicalMusic());
//        musicList.add(new RockMusic());
//        musicList.add(new ElectroMusic());

    }

    public List<Music> getMusicList() {
        return musicList;
    }
}
