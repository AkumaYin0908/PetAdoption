package app.petadoption.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/dbpetadoption";
    private static final String USER = "root", PASS = "";
    private Connection sqlConnection;

    public void connect() {
        try {
            sqlConnection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection successful");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getSqlConnection() {
        return sqlConnection;
    }

}
