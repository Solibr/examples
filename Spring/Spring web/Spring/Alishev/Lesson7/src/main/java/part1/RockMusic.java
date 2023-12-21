package part1;

import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

// #new
// id можно не указывать. В данном случае id будет как имя класса только в lowerCamelCase
@Component
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Some rock music";
    }
}
