package com.mycompany.resumewebapp.student.entity;

import com.mycompany.resumewebapp.common.Person;

public class Student extends Person {

    private String university;
    private String password;

    public String getUniversity() {
        return university;
    }

    public Student setUniversity(String university) {
        this.university = university;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public Student setPassword(String password) {
        this.password = password;
        return this;
    }
    
    
}
