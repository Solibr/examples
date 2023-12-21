package part1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import part1.dao.PeopleDao;
import part1.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private PeopleDao peopleDao;

    @Autowired
    public PeopleController(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("people", peopleDao.getList());
        return "/people/peopleList";
    }

    // #new - позволяет распознавать часть url как переменную
    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleDao.get(id));
        return "/people/showPerson";
    }

}
