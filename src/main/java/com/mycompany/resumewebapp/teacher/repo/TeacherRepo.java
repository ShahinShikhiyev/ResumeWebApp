package com.mycompany.resumewebapp.teacher.repo;

import com.mycompany.resumewebapp.common.CommonRepo;
import com.mycompany.resumewebapp.student.entity.Student;
import com.mycompany.resumewebapp.teacher.entity.Teacher;

import java.util.List;

public class TeacherRepo implements CommonRepo<Teacher> {

    @Override
    public List<Teacher> getList() {
        return null;
    }

    @Override
    public void update(Teacher obj) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void insert(Teacher obj) {

    }

    @Override
    public Teacher findById(int id) {
        return null;
    }

    @Override
    public List<Student> getList(String name, String surname, String email, String university, Integer age, String password) {
        return null;
    }
}
