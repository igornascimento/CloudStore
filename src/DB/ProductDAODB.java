package DB;

import DAO.ProductDAO;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            command.setString(1, product.getName());
            command.setString(2, product.getDescription());
            command.setInt(3, product.getQuantity());
            command.setDouble(4, product.getValue());
            command.setString(5, product.getUnityOfMeasure());
            command.executeUpdate();
            // get the id
            ResultSet result = command.getGeneratedKeys();
            if (result.next()) {
                id = result.getInt(1);
            } else {
                throw new SQLException();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(Product product) {
        try {
            String sql = "DELETE FROM product WHERE id = ?";
            connect(sql);
            command.setInt(1, product.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Product product) {
        try {
            String sql = "UPDATE product SET name = ?, description = ?, quantity = ?, price = ?, unity = ? WHERE id = ?";
            connect(sql);
            command.setString(1, product.getName());
            command.setString(2, product.getDescription());
            command.setInt(3, product.getQuantity());
            command.setDouble(4, product.getValue());
            command.setString(5, product.getUnityOfMeasure());
            command.setInt(5, product.getId());
        } catch(SQLException e) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customer";
            connect(sql);
            ResultSet result = command.executeQuery();
            while (result.next()) {
                list.add( new Product(result.getInt("id"),
                                      result.getString("name"),
                                      result.getString("description"),
                                      result.getInt("quantity"),
                                      result.getDouble("price"),
                                      result.getString("unity")));
            }
        } catch(SQLException e) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
        return list;
    }

    @Override
    public Product getById(Product product) {
        try {
            String sql = "SELECT * FROM product WHERE id = ?";
            connect(sql);
            command.setInt(1, product.getId());
            ResultSet result = command.executeQuery();
            if (result.next()) {
                new Product(result.getInt("id"),
                            result.getString("name"),
                            result.getString("description"),
                            result.getInt("quantity"),
                            result.getDouble("price"),
                            result.getString("unity"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAODB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return null;
    }
    
}
