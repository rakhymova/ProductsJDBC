package kz.aitujava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// this class is needed to connect our Java application with my Database
public class DatabaseConnection implements idbINTerface {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/Database1"; // Database1 is the name of my database in pgAdmin
        try {
            // loading the driver’s class file into memory
            Class.forName("org.postgresql.Driver");

            // actually connecting java with our database
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "73arorak");

            return con;
        } catch (Exception e) { // catching an exception if there is any
            System.out.println(e);
            return null;
        }
    }
}