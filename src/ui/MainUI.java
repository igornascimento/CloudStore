package ui;

import repository.ClientRepository;
import view.menu.MainMenu;
import util.Console;
import view.menu.ClientMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {

    private ClientRepository clientsList;
    
    public MainUI() {
        this.clientsList = new ClientRepository();
    }
    
    public void execute() {
        
        int option = 0;
        do {
            System.out.println( MainMenu.getOptions() );
            option = Console.scanInt("Informe a opção para prosseguir:");
            switch (option) {
                case MainMenu.OP_CLIENTES:
                    new ClientUI(this.clientsList).show();
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Finalizando aplicação.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != MainMenu.OP_SAIR);
        
    }
    
}
