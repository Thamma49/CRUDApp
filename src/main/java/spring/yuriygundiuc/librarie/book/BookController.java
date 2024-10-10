package spring.yuriygundiuc.librarie.book;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/books")
public class BookController {
private final BookDAO bookDAO;
@Autowired
public BookController(BookDAO bookDAO ) {
    this.bookDAO = bookDAO;

}
@GetMapping()
    public String index(Model model) throws SQLException, PSQLException {

    model.addAttribute("book",bookDAO.index());

    return "base/index";
}

@PostMapping("/stage2")
public String stage2(@ModelAttribute("book") Book book) throws SQLException, PSQLException {

    return "redirect:/s2ppl";
}
}
