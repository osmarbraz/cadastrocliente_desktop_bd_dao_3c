
import controle.CtrCliente;

/**
 * Classe que possui a operação main da aplicação. 
 * 
 * Inicializa o sistema.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 18-nov-2013 15:22:20
 */
public class Principal {

    /**
     * Inicia a aplicação.
     *
     * @param args args
     */
    public static void main(String[] args) {

        CtrCliente controle = new CtrCliente();
        controle.executar();

    }
}
