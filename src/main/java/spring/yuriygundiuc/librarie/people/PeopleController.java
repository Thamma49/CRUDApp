package spring.yuriygundiuc.librarie.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.yuriygundiuc.librarie.book.BookDAO;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonValidator personValidator;
    private final PersonDAO personDAO;
    private  final BookDAO bookDAO;
    @Autowired
    public PeopleController(PersonValidator personValidator, PersonDAO personDAO, BookDAO bookDAO) {
        this.personValidator = personValidator;
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "/PeoplesControl/ppl";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model)throws SQLException {
        model.addAttribute("person", personDAO.show(id));
        model.addAttribute("books", bookDAO.yet(id));
        return "/PeoplesControl/showPpl";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            personValidator.validate(person, bindingResult);
            return "PeoplesControl/new";
        }
        return "PeoplesControl/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "PeoplesControl/new";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit( Model model, @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()) {
//            return "PeoplesControl/editppl";
//        }
        model.addAttribute("person", personDAO.show(id));
        return "PeoplesControl/editppl";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) {
            return "PeoplesControl/editppl";
        }
        personDAO.update(id, person);
        return "redirect:/people";
    }

//    @DeleteMapping("/{id}/delete")
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

}
