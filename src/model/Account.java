package model;

import java.util.Random;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Account {

    private int accoutNumber;
    private double balance;

    public Account() {
        this.accoutNumber = this.generateAccountNumber();
        this.balance = 0.0;
    }
    
    /**
     * Generates new account number of a random from 00000 to 99999
     * @return int accountNumber
     */
    public int generateAccountNumber() {
        Random rnd = new Random();
        return rnd.nextInt(99999 - 00000 + 1) + 00000;
    }

    public int getAccoutNumber() {
        return accoutNumber;
    }

    public void setAccoutNumber(int accoutNumber) {
        this.accoutNumber = accoutNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    /**
     * Credit operation for the account
     * @return boolean
     */
    public boolean credit(double value) {
        this.balance += value;
        return true;
    }
    
    /**
     * Debit operation for the account
     * @return boolean
     */
    public boolean debit(double value) {
        if (this.balance >= value) {
            this.balance -= value;
            return true;
        }
        return false;
    }
    
}
