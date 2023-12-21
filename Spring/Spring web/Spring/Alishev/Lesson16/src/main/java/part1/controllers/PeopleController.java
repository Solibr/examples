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

    @GetMapping("/{id}")
    public String get(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleDao.get(id));
        return "/people/showPerson";
    }

    // #new - получение формы для добавления Person
    @GetMapping("/new")
    public String addForm() {
        return "/people/addForm";
    }

    // #new - получение post запроса и редирект на начальный список
    // @RequestParam("name") - аннотация подставляет в параметр метода параметры запроса.
    // В GET запросах тело пустое и параметрами являются параметры в queryString
    // В POST запросах запрещено передавать параметры в queryString и они передаются в теле запроса.
    @PostMapping()
    public String postPerson(@RequestParam("name") String name) {
        peopleDao.save(new Person(name, 0));
        return "redirect:/people";
    }


}
