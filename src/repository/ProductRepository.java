package repository;

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
    
    public boolean add(Product customer) {
        return this.products.add(customer);
    }
    
    public ArrayList<Product> getList() {
        return this.products;
    }
    
}
