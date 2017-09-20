package ui;

import java.util.ArrayList;
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
                case CustomerMenu.OP_LISTAR:
                    listCustomers();
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
            String address = Console.scanString("Informe o endereço:");
            String zipCode = Console.scanString("Informe o CEP:");
            this.customerList.add(new Customer(name, document, address, zipCode));
        }
    }

    private void listCustomers() {
        if (this.customerList.getList() == null || this.customerList.getList().size() <= 0) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            System.out.println(
                    String.format("%-10s", "|CPF") +"\t"+ 
                    String.format("%-20s", "|NOME") +"\t"+ 
                    String.format("%-30s", "|ENDEREÇO") +"\t"+ 
                    String.format("%-20s", "|CEP") );
            for (Customer c : this.customerList.getList()) {
                System.out.println(
                    String.format("%-10s", c.getDocument()) +"\t"+ 
                    String.format("%-20s", c.getName()) +"\t"+ 
                    String.format("%-30s", c.getAddress()) +"\t"+ 
                    String.format("%-20s", c.getZipCode()) );
            }
        }
    }
    
}
