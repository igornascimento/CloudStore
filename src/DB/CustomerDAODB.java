package DB;

import DAO.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author 180503743
 */
public class CustomerDAODB implements CustomerDAO {

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
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void save(Customer customer) {
        int id = 0;
        try {
            String sql = "INSERT INTO customer (name, document, email) VALUES (?, ?, ?)";
            this.connectGettingId(sql);
            command.setString(1, customer.getName());
            command.setString(2, customer.getDocument());
            command.setString(3, customer.getEmail());
            command.executeUpdate();
            // obtem o id
            ResultSet result = command.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
            } else {
                throw new SQLException();
            }
        } catch(SQLException e) {
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(Customer customer) {
        try {
            String sql = "DELETE FROM customer WHERE id = ?";
            connect(sql);
            command.setInt(1, customer.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            String sql = "UPDATE customer set name = ?, document = ?, email = ? WHERE id = ?";
            connect(sql);
            command.setString(1, customer.getName());
            command.setString(2, customer.getDocument());
            command.setString(3, customer.getEmail());
            command.setInt(4, customer.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Customer> list() {
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";
            connect(sql);
            ResultSet result = command.executeQuery();
            while (result.next()) {
                list.add(new Customer( result.getInt("id"),
                                       result.getString("name"),
                                       result.getString("email"),
                                       result.getString("document") ));
            }
        } catch(SQLException e) {
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    @Override
    public Customer getById(Customer customer) {
        try {
            String sql = "SELECT * FROM customer WHERE id = ?";
            connect(sql);
            command.setInt(1, customer.getId());
            ResultSet result = command.executeQuery();
            if (result.next()) {
                return new Customer( result.getInt("id"),
                                     result.getString("name"),
                                     result.getString("email"),
                                     result.getString("document"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return null;
    }
    
    
    
}
