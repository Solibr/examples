package part1.controllers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import part1.dao.PeopleDao;
import part1.model.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public PeopleDao peopleDao;

    public AdminController(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @GetMapping()
    public String getList(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", peopleDao.getList());
        return "/admin/admin";
    }

    /*@ResponseBody
    @PostMapping("/new")
    public String setAdmin(@ModelAttribute Person person, Model model, @RequestParam int newAdmin) {
        //int id = person.getId();

        return "Admin was defined with id " + newAdmin;
        //System.out.println("======== TEST");
        //return "admin/admin";
    }*/

    @ResponseBody
    @PostMapping("/new")
    public String setAdmin(@ModelAttribute("person") Person person) {
        int id = person.getId();

        return "Admin was defined with id " + id;
        //System.out.println("======== TEST");
        //return "admin/admin";
    }


}
