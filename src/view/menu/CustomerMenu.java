package view.menu;

import repository.CustomerRepository;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class CustomerMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "\n1- Cadastrar cliente;"
                + "\n2- Listar clientes;"
                + "\n0- Voltar;"
                + "\n------------------");
    }
    
}
