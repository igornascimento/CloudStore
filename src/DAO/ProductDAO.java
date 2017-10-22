package DAO;

import java.util.List;
import model.Product;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public interface ProductDAO {
    
    public void save(Product product);
    
    public void delete(Product product);
    
    public void update(Product product);
    
    public List<Product> list();
    
    public Product getById(Product product);
    
}
