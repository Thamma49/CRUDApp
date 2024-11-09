package spring.yuriygundiuc.librarie.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }
   @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personDAO.showOptional(person.getId()).isPresent()) {
            errors.rejectValue("id", "person.person_id.exists");
        }
         if (personDAO.showOptional(person.getName()).isPresent()) {
            errors.rejectValue("name",null,"person.name.must.be.declare");
        }
        else if (personDAO.showOptional(person.getSurName()).isPresent()) {
            errors.rejectValue("surname",null,"person.surname.must.be.declare");
        }
   }
    }

