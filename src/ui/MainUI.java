package ui;

import repository.CustomerRepository;
import view.menu.MainMenu;
import util.Console;
import view.menu.CustomerMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {

    private CustomerRepository clientsList;
    private ProductRepository productsList;
    
    public MainUI() {
        this.clientsList = new CustomerRepository();
        this.productsList = new ProductRepository();
    }
    
    public void execute() {
        
        int option = 0;
        do {
            System.out.println( MainMenu.getOptions() );
            option = Console.scanInt("\nInforme a opção para prosseguir:");
            switch (option) {
                case MainMenu.OP_CLIENTES:
                    new CustomerUI(this.clientsList).execute();
                    break;
                case MainMenu.OP_PRODUTOS:
                    new ProductUI(this.productsList).execute();
                    break;
                case MainMenu.OP_SALDO:
                    new BalanceUI(this.balance).execute();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("\nFinalizando aplicação.");
                    break;
                default:
                    System.out.println("\nOpção inválida.");
                    break;
            }
        } while (option != MainMenu.OP_SAIR);
        
    }
    
}
