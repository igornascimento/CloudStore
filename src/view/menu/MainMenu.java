package view.menu;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainMenu {
    
    public static final int OP_CLIENTES = 1;
    public static final int OP_SAIR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "\n1- Clientes;"
                + "\n0- Sair;"
                + "\n------------------" );
    }
    
}
