package spring.yuriygundiuc.librarie.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.yuriygundiuc.librarie.book.Book;

import java.util.List;

@Controller
@RequestMapping("/ppl")
public class PeopleController {
    private final PersonValidator personValidator;
    private final PersonDAO personDAO;


    @Autowired
    public PeopleController(PersonValidator personValidator, PersonDAO personDAO, PersonDAO peopleDAO) {
        this.personValidator = personValidator;
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String people(Model model) {
        model.addAttribute("person", personDAO.index());
        return "/base/index";
    }
    @GetMapping("{id}")
    public String updatePerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/base/s2ppl";
    }
     @GetMapping("/search")
    public String search(@RequestParam(value = "name", required = false) Person person , Model model) {
if( personDAO.show(person.getPerson_id())==null){
    return "redirect:/index";
}

         return "/base/s2ppl";
    }

}
