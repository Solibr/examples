package part1;

import org.springframework.stereotype.Component;

// #new
// Аннотация обозначает, что даннный класс является бином для Spring context.
// В скобках его id. В данном случае id указали для простоты такой же, какой определился бы Spring автоматически. Можно было указать и другой id
@Component("classicalMusic")
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Some classical music";
    }
}
