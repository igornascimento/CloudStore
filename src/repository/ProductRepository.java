package repository;

import DB.ProductDAODB;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ProductRepository {
    
    private ArrayList<Product> products = new ArrayList<>();
    
    public boolean productExists(int id) {
        if (this.products != null) {
            for (Product p : this.products) {
                if (p.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean add(Product product) {
        ProductDAODB dao = new ProductDAODB();
        dao.save(product);
        return this.products.add(product);
    }
    
    public ArrayList<Product> getList() {
        ProductDAODB dao = new ProductDAODB();
        this.products = (ArrayList<Product>) dao.list();
        return this.products;
    }
    
}
