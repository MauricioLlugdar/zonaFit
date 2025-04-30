package zona_fit.connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection getConnection(){
        Connection conn = null;

        Dotenv dotenv = Dotenv.load();

        String dbHost = dotenv.get("DB_HOST");
        String dbPort = dotenv.get("DB_PORT");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbName = dotenv.get("DB_NAME");
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
