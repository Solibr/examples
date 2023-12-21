package com.example.SpringDataH2Relationship.test;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class Extractor {
    private final AR ar;

    public Extractor(AR ar) {
        this.ar = ar;
    }

    @Transactional
    public Set<B> extract() {
        A a = ar.findById(1).get();

        // Без этого работать не будет. Нужно как-то заисполльзовать коллекцию внутри транзакции, чтобы она подгрузилась
        a.getBList().size();

        return a.getBList();
    }

}
