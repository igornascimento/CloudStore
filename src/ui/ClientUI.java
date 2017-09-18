package ui;

import util.Console;
import repository.ClientRepository;
import view.menu.ClientMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ClientUI {

    private ClientRepository clientsList;
    
    public ClientUI(ClientRepository clientsList) {
        this.clientsList = clientsList;
    }
    
    public void execute() {
        int option = 0;
        do {
            System.out.println(ClientMenu.getOptions());
            option = Console.scanInt("Informe sua opção:");
            switch (option) {
                case ClientMenu.OP_CADASTRAR:
                    registerClient();
                    break;
                case ClientMenu.OP_LISTAR:
                    listClients();
                    break;
                case ClientMenu.OP_VOLTAR:
                    System.out.println("Exibindo menu principal");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != ClientMenu.OP_VOLTAR);
    }

    private void registerClient() {
        String document = Console.scanString("Informe o CPF:");
        if (this.clientsList.clientExists(document)) {
            System.out.println("Cliente já cadastrado.");
        } else {
            String name = Console.scanString("Informe o nome completo:");
            String address = Console.scanString("Informe o endereço:");
            String zipCode = Console.scanString("Informe o CEP:");
            this.clientsList.add(name, document, address, zipCode);
        }
    }

    private void listClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
