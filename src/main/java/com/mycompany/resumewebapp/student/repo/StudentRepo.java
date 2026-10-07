package com.mycompany.resumewebapp.student.repo;

import com.mycompany.resumewebapp.common.CommonRepo;
import com.mycompany.resumewebapp.common.MyDatebase;
import com.mycompany.resumewebapp.student.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements CommonRepo<Student> {

    @Override
    public List<Student> getList() {
        List<Student> result = new ArrayList<>();
        try (Connection connection = MyDatebase.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
                result.add(fillStudent(resultSet));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Student obj) {
        try (Connection connection = MyDatebase.connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update student set name=?, surname=?, email=?, age=?, university=? where id=?");
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setString(3, obj.getEmail());
            statement.setObject(4, obj.getAge());
            statement.setString(5, obj.getUniversity());
            statement.setInt(6, obj.getId());

            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = MyDatebase.connect()) {
            PreparedStatement statement = connection.prepareStatement("delete from student where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Student obj) {
        try (Connection connection = MyDatebase.connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into student (name, surname, email, age, university) values (?,?,?,?,?)");
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setString(3, obj.getEmail());
            statement.setObject(4, obj.getAge());
            statement.setString(5, obj.getUniversity());

            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        try (Connection connection = MyDatebase.connect()) {
            PreparedStatement statement = connection.prepareStatement("select * from student where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return fillStudent(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getList(String name, String surname, String email, String university, Integer age, String password) {
        List<Student> result = new ArrayList<>();
        StringBuilder query = new StringBuilder("select * from student where 1=1");

        if (name != null && !name.trim().isEmpty()) query.append(" and name=?");
        if (surname != null && !surname.trim().isEmpty()) query.append(" and surname=?");
        if (email != null && !email.trim().isEmpty()) query.append(" and email=?");
        if (university != null && !university.trim().isEmpty()) query.append(" and university=?");
        if (age != null && age > 0) query.append(" and age=?");
        if (password != null && !password.trim().isEmpty()) query.append(" and password=?");

        try (Connection connection = MyDatebase.connect()) {
            PreparedStatement statement = connection.prepareStatement(query.toString());
            int index = 1;

            if (name != null && !name.trim().isEmpty()) statement.setString(index++, name.trim());
            if (surname != null && !surname.trim().isEmpty()) statement.setString(index++, surname.trim());
            if (email != null && !email.trim().isEmpty()) statement.setString(index++, email.trim());
            if (university != null && !university.trim().isEmpty()) statement.setString(index++, university.trim());
            if (age != null && age > 0) statement.setInt(index++, age);
            if (password != null && !password.trim().isEmpty()) statement.setString(index++, password.trim());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(fillStudent(resultSet));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static Student fillStudent(ResultSet resultSet) throws Exception {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        student.setUniversity(resultSet.getString("university"));
        student.setPassword(resultSet.getString("password"));
        return student;
    }

    public List<Student> getList(String name, String surname, String email, String university, Integer age) {
        return getList(name, surname, email, university, age, null);
    }
}