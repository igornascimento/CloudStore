package DB;

import DAO.CustomerDAO;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Customer;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ProductDAODB implements CustomerDAO {

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
    
    @Override
    public void save(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getById(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
