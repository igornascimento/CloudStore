package repository;

import java.util.ArrayList;
import model.Account;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class AccountRepository {
    
    private ArrayList<Account> accounts = new ArrayList<>();
    
    public boolean accountExists(int accountNumber) {
        if (this.accounts != null) {
            for (Account a : this.accounts) {
                if (a.getAccoutNumber() == accountNumber) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean add(Account account) {
        return this.accounts.add(account);
    }
    
    public ArrayList<Account> getList() {
        return this.accounts;
    }
    
    /**
     * Credits the value for the new account and
     * Debits the value from the original account
     * @param Account originalAccount
     * @param Account newAccount
     * @param double value
     * @return boolean
     */
    public boolean transfer(Account originalAccount, Account newAccount, double value) {
        if (originalAccount.getBalance() >= value) {
            newAccount.credit(value);
            originalAccount.debit(value);
            return true;
        }
        return false;
    }
    
//    public credit(double value) {
//        
//    }
    
}
