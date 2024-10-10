package spring.yuriygundiuc.librarie.people;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int person_id;

    @NotEmpty(message ="imya ne mochet bit pustim")
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String name;

    @NotEmpty(message ="familiya ne mochet bit pustim")
    @Size(min = 2, max = 20, message = "Om 2 do 20 simvolov")
    private String surname;

    @NotEmpty(message = "vvedite vash vozrast")
    @Min(value=0,message = "min znach 0 ")
    private int age;

    public Person() {}
    public Person(int id, String name, String surname, int age) {
        this.person_id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;

    }
    public int getPerson_id() {
        return person_id;
    }
    public void setId(int id) {
        this.person_id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
