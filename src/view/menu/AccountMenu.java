package view.menu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class AccountMenu {

    public static final int OP_SALDO = 1;
    public static final int OP_CREDITAR = 2;
    public static final int OP_SACAR = 3;
    public static final int OP_TRANSFERIR = 4;
    public static final int OP_VOLTAR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "\n1- Verificar saldo;"
                + "\n2- Creditar;"
                + "\n3- Sacar;"
                + "\n4- Transferir;"
                + "\n0- Voltar;"
                + "\n------------------");
    }
}
