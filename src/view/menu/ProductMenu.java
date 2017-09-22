package view.menu;

/**
 *
 * @author 180503743
 */
public class ProductMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_VOLTAR = 0;
    
    public static String getOptions() {
        return (  "\n------------------"
                + "\n1- Cadastrar produto;"
                + "\n2- Listar produtos;"
                + "\n0- Voltar;"
                + "\n------------------");
    }
    
}
