package ui;

import model.Account;
import util.Console;
import view.menu.AccountMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class AccountUI {
    
    private Account account;
    
    public AccountUI(AccountRepository account) {
        this.account = account;
    }
    
    public void execute() {
        int option = 0;
        do {
            System.out.println(AccountMenu.getOptions());
            option = Console.scanInt("Informe sua opção:");
            switch (option) {
                case AccountMenu.OP_SALDO:
                    showBalance();
                    break;
                case AccountMenu.OP_CREDITAR:
                    doCredit();
                    break;
                case AccountMenu.OP_SACAR:
                    doWidrawal();
                    break;
                case AccountMenu.OP_TRANSFERIR:
                    doTransfer();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }
    
    public void showBalance() {
        System.out.println(
            String.format("", args));
    }
    
}
