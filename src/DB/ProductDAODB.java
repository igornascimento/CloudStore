package DB;

import DAO.ProductDAO;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ProductDAODB implements ProductDAO {

    private Connection conn = null;
    private PreparedStatement command = null;
    
    private void connect(String sql) throws SQLException {
        conn = ConnectionFactory.getConnection();
        command = conn.prepareStatement(sql);
    }
    
    private void connectGettingId(String sql) throws SQLException {
        conn = ConnectionFactory.getConnection();
        command = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }
    
    private void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void save(Product product) {
        int id = 0;
        try {
            String sql = "INSERT INTO product (name, description, quantity, price, unit) VALUES (?, ?, ?, ?, ?)";
            connectGettingId(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getById(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
