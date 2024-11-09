package spring.yuriygundiuc.librarie.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {

        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class) );
    }
    public Person show(int id) {
        return  jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
//        return (Person)jdbcTemplate.query("select * from person where id = ?", new PersonMapper(), id);
    }
    public Optional<Person> show(String email) {
        return jdbcTemplate.query("select * from person where email=?", new Object[] {email}
                , new BeanPropertyRowMapper<Person>(Person.class)).stream().findAny();
    }
    public Optional<Person> showOptional(int id) {
        return jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, new PersonMapper()).stream().findAny();
    }
    public Optional<Person> showOptional(String name) {
        return jdbcTemplate.query("select * from person where name = ?", new Object[]{name}, new PersonMapper()).stream().findAny();
    }
    public Optional<Person> showOptional(Person person) {
        return jdbcTemplate.query("select * from person where surname=?", new Object[]{person.getSurName()}, new PersonMapper()).stream().findAny();
    }

    public void save(Person person) {

        jdbcTemplate.update("insert into person(name,surname,email) values(?,?,?)",person.getName(),person.getSurName(),person.getEmail());
    }

    public void update(int id, Person updatedPerson) {

        jdbcTemplate.update("update person set name=?,email=? where id=?"
                ,updatedPerson.getName(),updatedPerson.getEmail(), id);
    }

    public void delete(int id) {

        jdbcTemplate.update("delete from person where id=?",id);
    }
//    public Person ininx (int id) {
//        return jdbcTemplate.query("select * from person as p join book as b on p.id = b.person_id ", new Object[]{id}, new PersonMapper());
//    }





}
