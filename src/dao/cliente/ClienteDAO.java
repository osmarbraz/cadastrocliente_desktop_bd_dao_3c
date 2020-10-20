package dao.cliente;

import java.util.List;

/**
 * Interface que define as operações para a persistência de cliente.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 14-nov-2012 16:08:57
 */
public interface ClienteDAO {

    public boolean inserir(Object obj);

    public int alterar(Object obj);

    public int excluir(Object obj);

    @SuppressWarnings("rawtypes")
    public List aplicarFiltro(Object obj);

    @SuppressWarnings("rawtypes")
    public List getLista();

}
