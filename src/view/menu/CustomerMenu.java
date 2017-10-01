package view.menu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class CustomerMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_ADICIONAR_CONTA = 3;
    public static final int OP_DETALHAR_CONTAS = 4;
    public static final int OP_VOLTAR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "\n1- Cadastrar cliente;"
                + "\n2- Listar clientes;"
                + "\n3- Criar nova conta para o usuário;"
                + "\n4- Detalhar contas;"
                + "\n0- Voltar;"
                + "\n------------------");
    }
    
}
