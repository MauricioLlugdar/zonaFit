package zona_fit.connection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDbTest { //Try to connect to Mysql
    @Test // Put the test annotation for JUnit
    public void testConnection() {
        try (Connection conn = Connect.getConnection()) {
            assertNotNull(conn); // If the conn is null
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            fail("Connection to mysql failed: " + e.getMessage());
        }
    }
}
