package spring.yuriygundiuc.librarie.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import spring.yuriygundiuc.librarie.people.Person;
import spring.yuriygundiuc.librarie.people.PersonMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Book> index() throws SQLException, BadSqlGrammarException {
        return jdbcTemplate.query("SELECT * FROM book", new BookMapper());
    }
    public Book find(Book book) throws SQLException, BadSqlGrammarException {
        if(book.getId()<0){
            return null;
        }
//        return jdbcTemplate.query("select * from book where id=?", new Object[]{book.getBook_id()},new BeanPropertyRowMapper(Book.class) );
        return null;
    }
    public Book show(int id) {
        return  jdbcTemplate.query("select * from book where id = ?", new Object[]{id}, new BookMapper()).stream().findAny().orElse(null);

    }


    public Optional<Book> showOptional(int id) {
        return jdbcTemplate.query("select * from book where id = ?", new Object[]{id}, new BookMapper()).stream().findAny();
    }
    public Optional<Book> showOptional(String author) {
        return jdbcTemplate.query("select * from book where  author= ?", new Object[]{author}, new BookMapper()).stream().findAny();
    }

    public Optional<Book> showOptional(Book book) {
        return jdbcTemplate.query("select * from book where name=?", new Object[]{book.getTitle()}, new BookMapper()).stream().findAny();
    }
    public void save(Book book) {

        jdbcTemplate.update("insert into book(author,name,date) values(?,?,?)",book.getAuthor(),book.getTitle(),book.getYear());
    }
    public void delete(int id) {

        jdbcTemplate.update("delete from book where id=?",id);
    }
    public void yetBooks(int id,int idd ) {
         jdbcTemplate.update("update book set person_id=? where id=? ",idd,id);
    }
    public void notYet(int id) {
        jdbcTemplate.update("UPDATE book set person_id = null where id=?", id);
    }


//    public Book yet(int author) {
//        return jdbcTemplate.query("select * from book where person_id=?", new Object[]{author}, new BookMapper()).stream().findAny().orElse(null);
//    }
    public List<Book> yet(int author) {
        return jdbcTemplate.query("select * from book where person_id=?", new Object[]{author}, new BookMapper());
    }
//    public Integer check (int id){
//if(jdbcTemplate.query("select * from book where id=?",Object[]{id}, Integer.class) ){
//    return 1;
//}
//return 0;
//    }

//    public boolean check(int id)throws BadSqlGrammarException {
//        String sql = "SELECT person_id FROM book WHERE id = ?";
//        Integer personId = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
//
//        // Проверка на null: если personId не null, возвращаем true, иначе false
//        return personId != null;
//    }
public boolean check(int id) throws BadSqlGrammarException {
    String sql = "SELECT person_id FROM book WHERE id = ?";
    try {
        Integer personId = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        // Проверка на null: если personId не null, возвращаем true, иначе false
        return personId != null;
    } catch (EmptyResultDataAccessException e) {
        // Если запись не найдена, возвращаем false
        return false;
    }
}


}
