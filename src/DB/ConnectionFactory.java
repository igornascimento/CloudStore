package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 180503743
 */
public class ConnectionFactory {

    // private static final String db = "jdbc:postgresql://localhost:5432/ProjetoBanco4";
    // private static final String user = "postgres";
    // private static final String pass = "123456";
    
    private static final String db = "jdbc:mysql://localhost:3306/cloudstore?user=root&password=";
    private static final String user = "root";
    private static final String pass = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
}
