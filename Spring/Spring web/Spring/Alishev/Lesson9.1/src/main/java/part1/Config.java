package part1;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("/part1")
@PropertySource("classpath:musicPlayer.properties")
public class Config {

    // #new - определение бинов ниже
    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public ElectroMusic electroMusic() {
        return new ElectroMusic();
    }

    @Bean
    public MusicList musicList() {
        return new MusicList(rockMusic(), classicalMusic(), electroMusic());
    }

    @Bean
    @Scope("prototype")
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

}
