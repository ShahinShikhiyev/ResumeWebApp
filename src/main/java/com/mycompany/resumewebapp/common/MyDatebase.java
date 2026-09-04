package com.mycompany.resumewebapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatebase {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//Java DataBase Connectivity API
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/resume?" +
                        "user=root&password=sahin123&characterEncoding=UTF-8");
    }
}