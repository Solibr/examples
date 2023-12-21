package part1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import part1.Message;
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

    @GetMapping("/new")
    public String addForm(@ModelAttribute("person") Person person) {
        return "/people/addForm";
    }

    // #new - использование ModelAttribute перед параметром, чтобы автоматически собрать параметры запроса в поля объекта Person и передать его в Model
    @PostMapping()
    public String postPerson(@ModelAttribute("person") Person person) {
        peopleDao.save(person);
        return "redirect:/people";
    }

    // #new - использование ModelAttribute перед параметром, чтобы во всех методых контроллера передать в Model атрибут с ключом "message" и значением - возвращаемым объектом
    // Во всех html формах видно использование данного объкта
    @ModelAttribute("message")
    public Message declareMessage() {
        return new Message("Made in China");
    }


}
