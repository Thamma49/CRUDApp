package spring.yuriygundiuc.librarie.book;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String name;
    @NotEmpty
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String author;
    private int date ;

    public Book(){

    }
    public Book(int book_id, String title, String author, int year) {
        this.id = book_id;
        this.name = title;
        this.author = author;
        this.date = year;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return name;
    }
    public void setTitle(String title) {
        this.name = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return date;
    }
    public void setYear(int year) {
        this.date = year;
    }



}
