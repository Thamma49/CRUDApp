package spring.yuriygundiuc.librarie.book;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book booke = new Book();
        booke.setId(rs.getInt("id"));
        booke.setTitle(rs.getString("name"));
        booke.setAuthor(rs.getString("author"));
        booke.setYear(rs.getInt("date"));

        System.out.println("map row ");
        return booke;
    }
}
