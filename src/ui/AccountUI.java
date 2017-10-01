package ui;

import java.util.Iterator;
import model.Account;
import repository.AccountRepository;
import util.Console;
import view.menu.AccountMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class AccountUI {
    
    private AccountRepository accountList;
    
    public AccountUI(AccountRepository accountList) {
        this.accountList = accountList;
    }
    
    public void execute() {
        int option = 0;
        do {
            System.out.println(AccountMenu.getOptions());
            option = Console.scanInt("Informe sua opção:");
            switch (option) {
                case AccountMenu.OP_LISTAR:
                    listAccounts();
                    break;
                case AccountMenu.OP_SALDO:
                    showBalance();
                    break;
                case AccountMenu.OP_CREDITAR:
                    //doCredit();
                    break;
                case AccountMenu.OP_SACAR:
                    //doWidrawal();
                    break;
                case AccountMenu.OP_TRANSFERIR:
                    //doTransfer();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }
    
    public void showBalance() {
        
        System.out.println(
            String.format("%-10s", "|SALDO") + "\n" + 
            String.format("%-10s", this.accountList) );
    }
    
    public void listAccounts() {
        if (this.accountList.getList() == null || this.accountList.getList().size() <= 0) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println(
                    String.format("%-20s", "|NRO DA CONTA") +"\t"+ 
                    String.format("%-20s", "|SALDO") );
            for (Account a : this.accountList.getList()) {
                System.out.println(
                    String.format("%-20s", a.getAccoutNumber()) +"\t"+ 
                    String.format("%-20s", a.getBalance()) );
            }
        }
    }
    
}
