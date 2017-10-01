package ui;

import java.util.ArrayList;
import model.Account;
import model.Customer;
import util.Console;
import repository.CustomerRepository;
import view.menu.CustomerMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class CustomerUI {

    private CustomerRepository customerList;
    
    public CustomerUI(CustomerRepository customersList) {
        this.customerList = customersList;
    }
    
    public void execute() {
        int option = 0;
        do {
            System.out.println(CustomerMenu.getOptions());
            option = Console.scanInt("Informe sua opção:");
            switch (option) {
                case CustomerMenu.OP_CADASTRAR:
                    registerCustomer();
                    break;
                case CustomerMenu.OP_ADICIONAR_CONTA:
                    //addAccount();
                    break;
                case CustomerMenu.OP_LISTAR:
                    listCustomers();
                    break;
                case CustomerMenu.OP_DETALHAR_CONTAS:
                    detailAccounts();
                    break;
                case CustomerMenu.OP_VOLTAR:
                    System.out.println("Exibindo menu principal");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != CustomerMenu.OP_VOLTAR);
    }

    private void registerCustomer() {
        String document = Console.scanString("Informe o CPF:");
        if (this.customerList.customerExists(document)) {
            System.out.println("Cliente já cadastrado.");
        } else {
            String name = Console.scanString("Informe o nome completo:");
            String email = Console.scanString("Informe o email:");
            this.customerList.add(new Customer(name, document, email));
        }
    }

    private void listCustomers() {
        if (this.customerList.getList() == null || this.customerList.getList().size() <= 0) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println(
                    String.format("%-10s", "|CPF") +"\t"+ 
                    String.format("%-20s", "|NOME") +"\t"+ 
                    String.format("%-30s", "|EMAIL") );
            for (Customer c : this.customerList.getList()) {
                System.out.println(
                    String.format("%-10s", c.getDocument()) +"\t"+ 
                    String.format("%-20s", c.getName()) +"\t"+ 
                    String.format("%-30s", c.getEmail()) );
                if (c.getAccounts().size() > 0) {
                    System.out.println("Contas vinculadas:");
                    for (Account acc : c.getAccounts()) {
                        System.out.println( 
                                String.format("%-70s", acc.getAccoutNumber()) + "\n" +
                                String.format("%-10s", acc.getBalance()) );
                    }
                    System.out.println("---------------");
                }
            }
        }
    }
    
    public void detailAccounts() {
        String document = Console.scanString("Informe o CPF para prosseguir:");
        for (Customer c : this.customerList.getList()) {
            if (c.getDocument().equals(document)) {
                ArrayList<Account> accounts = c.getAccounts();
                System.out.println("Contas do cliente:");
                for (Account acc : accounts) {
                    System.out.println(acc.getAccoutNumber());
                }
                int selectedAccount = Console.scanInt("Informe o número da conta para exibir o saldo ou 0 para voltar:");
                while (selectedAccount != 0) {
                    for (Account ac : accounts) {
                        if (ac.getAccoutNumber() == selectedAccount) {
                            System.out.println("Saldo atual da conta: " + ac.getBalance());
                            break;
                        } else {
                            System.out.println("Número da conta incorreto. Tente novamente ou 0 para sair.");
                        }
                    }
                    selectedAccount = Console.scanInt("Informe o número da conta para exibir o saldo ou 0 para voltar:");
                }
            } else {
                System.out.println("Documento não encontrado.");
            }
        }
    }
    
}
