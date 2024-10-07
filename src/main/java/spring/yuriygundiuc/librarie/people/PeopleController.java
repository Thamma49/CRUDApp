package spring.yuriygundiuc.librarie.people;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ppl")
public class PeopleController {
    private PeopleDAO peopleDAO;
//    @Autowired
//    public PeopleController(BookDAO bookDAO ) {
//        this.peopleDAO = peopleDAO;
//
//    }
//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("");
//        return "/base/ppl";
//    }
//    @GetMapping("/{id}")
//    public String id(Model model) {
//model.addAttribute("person", peopleDAO.index());
//return "/{id}";
//    }
}
