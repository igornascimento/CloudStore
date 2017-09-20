package repository;

import java.util.ArrayList;
import model.Customer;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class CustomerRepository {

    private ArrayList<Customer> customers = new ArrayList<>();
    
    public boolean customerExists(String document) {
        if (this.customers != null) {
            for (Customer c : this.customers) {
                if (c.getDocument().equals(document)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean add(Customer customer) {
        return this.customers.add(customer);
    }
    
    public ArrayList<Customer> getList() {
        return this.customers;
    }
    
}
