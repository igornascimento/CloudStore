package repository;

import DB.CustomerDAODB;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();
    
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
        CustomerDAODB dao = new CustomerDAODB();
        dao.save(customer);
        return this.customers.add(customer);
    }
    
    public ArrayList<Customer> getList() {
        CustomerDAODB dao = new CustomerDAODB();
        this.customers = dao.list();
        return (ArrayList<Customer>) this.customers;
    }
    
}
