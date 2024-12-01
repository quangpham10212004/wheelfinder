/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Entity;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Quang
 */
public class Database {
    private String user = "root";
    private String password = "Quang@2004";
    private String url = "jdbc:mysql://localhost/wheelfinder";
    private Statement statement ;
    public Database(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            // System.out.println("Connected successfully"); // kiem tra ket noi
            
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            // System.out.println("Nothing happen!");
        }
    }
    public Statement getStatement(){
        return statement;
    }
}
