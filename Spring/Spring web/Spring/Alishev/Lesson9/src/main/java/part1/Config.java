package part1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// #new - отмечем класс как конфигурационный. Имя может быть любым.
@Configuration
@ComponentScan("/part1")                                // показываем где искать бины
@PropertySource("classpath:musicPlayer.properties")     // показываем где искать свойства
public class Config {

}
