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
    
    public int generateAccountNumber() {
        Random rnd = new Random();
        // generating random from 00000 to 99999
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
    
    
    
}
