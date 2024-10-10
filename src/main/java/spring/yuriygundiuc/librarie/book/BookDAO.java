package spring.yuriygundiuc.librarie.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Book> index() throws SQLException, BadSqlGrammarException {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<Book>(Book.class));
    }
    public Book find(Book book) throws SQLException, BadSqlGrammarException {
        if(book.getBook_id()<0){
            return null;
        }
//        return jdbcTemplate.query("select * from book where book_id=?", new Object[]{book.getBook_id()},new BeanPropertyRowMapper(Book.class) );
        return null;
    }



}
