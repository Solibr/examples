package part1;

import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Some rock music";
    }
}
