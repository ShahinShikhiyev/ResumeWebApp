package com.mycompany.resumewebapp.common;

public class Person {

    private Integer id;

    private String name;

    private String surname;

    private Integer age;
    //Burada Integer ve Double null deyeri ala biler. Ancaq int ve double olsaydi null ola bilmezdi.

    private String email;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void increaseAge(){
        age++;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {//girilen melumatlari neticede gosterir
        return name+" "+surname+" "+age;
    }
}
