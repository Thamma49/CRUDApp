package spring.yuriygundiuc.librarie.book;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.yuriygundiuc.librarie.people.Person;
import spring.yuriygundiuc.librarie.people.PersonDAO;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final PersonDAO personDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, BookValidator bookValidator, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.bookValidator = bookValidator;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) throws SQLException, PSQLException {
        model.addAttribute("books", bookDAO.index());
        return "books/allBooks";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model,@ModelAttribute("person") Person person) throws SQLException {
        model.addAttribute("book", bookDAO.show(id));
        model.addAttribute("persons", personDAO.index());
        return "books/showBook";
    }


    @GetMapping("/new")
    public String showNew(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bookValidator.validate(book, bindingResult);
            return "books/new";
        }
        bookDAO.save(book);
        return "redirect:/books";//в редиректе именно ссылка там где ее вставлять в гугле
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}/{person}")
    public String setBook(@ModelAttribute("book") @Valid Book book,@PathVariable("id") int id  ,Model model,@PathVariable("person") int idd )throws SQLException, PSQLException {
//        model.addAttribute("books",bookDAO.select() );
bookDAO.yetBooks(id,idd);
        return "redirect:/books";//в редиректе именно ссылка там где ее вставлять в гугле
    }
    @PostMapping("/{id}/release")
    public String release(@PathVariable("id") int id) {
        bookDAO.notYet(id);
        return "redirect:/books";
    }
}


