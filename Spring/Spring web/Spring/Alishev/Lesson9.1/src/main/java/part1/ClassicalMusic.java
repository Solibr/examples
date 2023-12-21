package part1;

import org.springframework.stereotype.Component;

// Аннотация обозначает, что даннный класс является бином для Spring context.
// В скобках его id. id в данном примере не отличается от того, что был бы присвоен автоматически. Можно было бы указать любой другой
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Some classical music";
    }
}
