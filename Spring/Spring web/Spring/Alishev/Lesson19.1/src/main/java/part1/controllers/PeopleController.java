package part1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import part1.dao.PeopleDao;
import part1.model.Person;

import javax.validation.Valid;

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

    @PostMapping()
    public String postPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/people/addForm";
        peopleDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleDao.get(id));
        return "/people/editForm";
    }

    @PatchMapping("/{id}")
    public String patchPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/people/editForm";
        peopleDao.update(id, person);
        return "redirect:/people/" + id;
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        peopleDao.delete(id);
        return "redirect:/people";
    }


}
