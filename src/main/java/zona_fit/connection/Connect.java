package zona_fit.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection getConnection(){
        Connection conn = null;
        String dbHost = System.getenv("DB_HOST");
        String dbPort = System.getenv("DB_PORT");
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");
        String dbName = System.getenv("DB_NAME");
        var url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; // connection line

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // connection class Driver
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

        }catch (Exception e){
            System.out.println("ERROR: CONNECTING TO DATABASE" + e.getMessage());
        }
        return conn;
    }
}
