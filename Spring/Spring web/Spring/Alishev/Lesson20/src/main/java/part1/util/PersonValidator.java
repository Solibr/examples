package part1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import part1.dao.PeopleDao;
import part1.model.Person;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private PeopleDao peopleDao;

    @Autowired
    public PersonValidator(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    // Описываем какие классы поддерживает этот валидатор
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String newEmail = ((Person) target).getEmail();
        Optional<Person> storedPerson = peopleDao.emailPresent(newEmail);
        if (storedPerson.isPresent() && storedPerson.get().getId() != ((Person) target).getId()) {
            errors.rejectValue("email", "", "This email already taken");
        }
    }
}
