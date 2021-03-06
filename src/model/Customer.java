package model;

import java.util.ArrayList;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Customer {
    
    private int id = 0;
    private final String name;
    private final String document;
    private final String email;
    private final ArrayList<Account> accounts = new ArrayList<>();
    
    public Customer(String name, String document, String email) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.accounts.add( new Account() );
    }
    
    public Customer(int id, String name, String document, String email) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.accounts.add( new Account() );
    }

    public int setId() {
        return id;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    
    public void addAccount(int accountNumber) {
        this.accounts.add( new Account() );
    }
    
}
