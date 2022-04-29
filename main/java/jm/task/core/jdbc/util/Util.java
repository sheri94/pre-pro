package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private String user = "root";
    private String pass = "1234";
    private String url = "jdbc:mysql://localhost:3306/test";
    private Connection connection;
    //Class.forName("com.mysql.cj.jdbc.Driver");


     public  Connection getConnection() {
         try {
             connection = DriverManager
                     .getConnection(url, user, pass);
          //   System.out.println("Нормально");
         } catch (SQLException e) {
             throw new RuntimeException();
         }
        return connection;
    }
}
