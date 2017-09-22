package ui;

import repository.ProductRepository;
import util.Console;
import view.menu.ProductMenu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ProductUI {
    
    private ProductRepository productList;
    
    public ProductUI(ProductRepository productList) {
        this.productList = productList;
    }
    
    public void execute() {
        int option = 0;
        do {
            switch (option) {
                case ProductMenu.OP_CADASTRAR:
                    registerProduct();
                    break;
                case ProductMenu.OP_LISTAR:
                    listProducts();
                    break;
                case ProductMenu.OP_VOLTAR:
                    System.out.println("Exibindo menu principal");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (option != 0);
    }

    private void registerProduct() {
        int id = Console.scanInt("Informe o ID do produto");
        if (this.productList.customerExists(id)) {
            System.out.println("Produto já cadastrado.");
        } else {
            String name = Console.scanString("Informe o nome do produto:");
            String description = Console.scanString("Informe a descrição do produto:");
            String quantity = Console.scanString("Informe a quantidade do produto:");
            String value = Console.scanString("Informe o valor unitário do produto:");
        }
    }
    
}
