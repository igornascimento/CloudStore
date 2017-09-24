package ui;

import repository.CustomerRepository;
import repository.ProductRepository;
import view.menu.MainMenu;
import util.Console;
import view.menu.CustomerMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {

    private CustomerRepository customersList;
    private ProductRepository productsList;
    
    public MainUI() {
        this.customersList = new CustomerRepository();
        this.productsList = new ProductRepository();
    }
    
    public void execute() {
        
        int option = 0;
        do {
            System.out.println( MainMenu.getOptions() );
            option = Console.scanInt("\nInforme a opção para prosseguir:");
            switch (option) {
                case MainMenu.OP_CLIENTES:
                    new CustomerUI(this.customersList).execute();
                    break;
                case MainMenu.OP_PRODUTOS:
                    new ProductUI(this.productsList).execute();
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
