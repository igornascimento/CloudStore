package view.menu;

import repository.ClientRepository;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ClientMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "1- Cadastrar cliente;"
                + "2- Listar clientes;"
                + "0- Voltar;"
                + "\n------------------");
    }
    
}
