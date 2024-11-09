package spring.yuriygundiuc.librarie.people;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message ="imya ne mochet bit pustim")
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String name;

    @NotEmpty(message ="familiya ne mochet bit pustim")
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String surName;



    @NotEmpty(message = "vvedite norm email pls ")
    private String email;

    public Person() {}
    public Person(int id, String name, String surname,String email) {
        this.id = id;
        this.name = name;
        this.surName = surname;
        this.email = email;


    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surname) {
        this.surName = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
