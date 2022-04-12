package dao;

import dao.cliente.ClienteDAO;
import dao.cliente.HashMapClienteDAO;

/**
 * Implementa a fonte de dado para persistência em memória utilizando HashMap.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 14-nov-2012 16:08:57
 */
public class HashMapDAOFactory extends DAOFactory {

    public HashMapDAOFactory() {
    }

    /**
     * Retorna uma Cliente DAO
     *
     * @return ClienteDAO Um DAO para cliente
     */
    public ClienteDAO getClienteDAO() {
        return new HashMapClienteDAO();
    }
}
