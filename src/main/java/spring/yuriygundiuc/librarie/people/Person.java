package spring.yuriygundiuc.librarie.people;

public class Person {
    private int person_id;
    private String name;
    private String surname;
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
