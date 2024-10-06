package spring.yuriygundiuc.librarie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PeopleDAO {
//    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    public PeopleDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    public List<Person> index() {
//        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class) );
//    }
}
