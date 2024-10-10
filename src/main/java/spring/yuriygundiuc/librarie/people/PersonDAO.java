package spring.yuriygundiuc.librarie.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> index() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class) );
    }
    public Person show(int id) {
        return  jdbcTemplate.query("select * from person where person_id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }
    public Optional<Person> showOptional(int id) {
        return jdbcTemplate.query("select * from person where person_id = ?", new Object[]{id}, new PersonMapper()).stream().findAny();
    }
    public Optional<Person> showOptional(String name) {
        return jdbcTemplate.query("select * from person where name = ?", new Object[]{name}, new PersonMapper()).stream().findAny();
    }
    public Optional<Person> showOptional(Person person) {
        return jdbcTemplate.query("select * from person where surname=?", new Object[]{person.getSurname()}, new PersonMapper()).stream().findAny();
    }
//    public int insert(Person person) {
//return jdbcTemplate.query("select * from person where id=?",person.getPerson_id());
//    }
}
