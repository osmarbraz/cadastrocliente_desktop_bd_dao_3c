
import controle.CtrCliente;

/**
 * Classe que possui a operação main da aplicação.
 *
 * Inicializa o sistema.
 *
 * @author osmarbraz
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
