package spring.yuriygundiuc.librarie.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring.yuriygundiuc.librarie.people.Person;
import spring.yuriygundiuc.librarie.people.PersonDAO;

@Component
public class BookValidator implements Validator {
    private BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if(bookDAO.showOptional(book.getId()).isPresent()) {
            errors.rejectValue("id", "person.person_id.exists");
        }
        if (bookDAO.showOptional(book.getTitle()).isPresent()) {
            errors.rejectValue("title",null,"Title.name.must.be.declare");
        }
        else if (bookDAO.showOptional(book.getAuthor()).isPresent()) {
            errors.rejectValue("author",null,"Author.surname.must.be.declare");
        }

    }
}
