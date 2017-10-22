package DAO;

import java.util.List;
import model.Customer;

/**
 *
 * @author 180503743
 */
public interface CustomerDAO {
    
    public void save(Customer customer);
    
    public void delete(Customer customer);
    
    public void update(Customer customer);
    
    public List<Customer> list();
    
    public Customer getById(Customer customer);
    
}
