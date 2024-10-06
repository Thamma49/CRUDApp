package spring.yuriygundiuc.librarie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person=new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surName"));
        person.setAge(rs.getInt("age"));
        return person;

    }
}
