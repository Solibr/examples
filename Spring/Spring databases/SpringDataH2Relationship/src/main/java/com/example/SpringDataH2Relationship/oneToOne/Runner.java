package com.example.SpringDataH2Relationship.oneToOne;

import com.example.SpringDataH2Relationship.repositories.PassportRepository;
import com.example.SpringDataH2Relationship.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("OneToOne")
public class Runner implements CommandLineRunner {

    private final PersonRepository personRepository;
    private final PassportRepository passportRepository;

    public Runner(PersonRepository personRepository, PassportRepository passportRepository) {
        this.personRepository = personRepository;
        this.passportRepository = passportRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\nBefore update");
        personRepository.findAll().forEach(System.out::println);
        passportRepository.findAll().forEach(System.out::println);

        Person person = new Person("Sam", 35);
        //person.setSomeId(42L);
        Passport passport = new Passport("dgbsktr");

        // It's more reliable to set related entity in each object. But if we set relation only in one object, it must be owned entity (because it has joining column), and then we must save exactly that entity
        passport.setPerson(person);
        person.setPassport(passport);

        // We only need to save person (or passport), if we have set relation on each side. Passport will be saved automatically due to cascading. But if we have set relation only on one side (owned), as was said before, we must save exactly that entity. In other cases either joining column will be null (as result relation would not be saved), or one of entities would not be saved
        passportRepository.save(passport);
        //personRepository.save(person);

        System.out.println("\nAfter update");
        personRepository.findAll().forEach(System.out::println);
        passportRepository.findAll().forEach(System.out::println);
        System.out.println("\n");
    }
}
