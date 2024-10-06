package spring.yuriygundiuc.librarie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
private final BookDAO bookDAO;
@Autowired
public BookController(BookDAO bookDAO ) {
    this.bookDAO = bookDAO;

}
@GetMapping()
    public String index(Model model) {
    model.addAttribute("book",bookDAO.index());
    return "base/index";
}

}