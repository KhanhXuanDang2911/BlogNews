package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    protected Connection connection;
    public DBContext(){
        final String URL = "jdbc:mysql://localhost:3306/blognews";
        final String USERNAME = "root";
        final String PASSWORD = "291104";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}