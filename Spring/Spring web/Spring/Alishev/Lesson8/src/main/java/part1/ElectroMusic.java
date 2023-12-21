package part1;

import org.springframework.stereotype.Component;

@Component
public class ElectroMusic implements Music {
    @Override
    public String getSong() {
        return "Some electro music";
    }
}
