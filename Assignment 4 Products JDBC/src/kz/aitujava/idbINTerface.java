package kz.aitujava;

import java.sql.Connection;
import java.sql.SQLException;

// creating an IDB Interface to create a DatabaseConnection class and connect our application with database
public interface idbINTerface {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}