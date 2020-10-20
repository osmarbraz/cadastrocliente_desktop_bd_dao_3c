package dao;

import dao.cliente.ClienteDAO;

/**
 * Abstrai as fontes de dados do sistema.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 07-nov-2013 21:43:35
 */
public abstract class DAOFactory {

    //Tipos de Fonte de Dados suportados pela Factory
    public static final int ORACLE = 1;
    public static final int HASHMAP = 2;
    public static final int RAF = 3;

    //Retorna o DAO instanciado
    public abstract ClienteDAO getClienteDAO();

    /**
     * Retorna a Factory do tipo especificado	
     * 
     * @param qualFabrica Especifica a fábrica a ser selecionada.
     * @return Um fábrica.
     */
    public static DAOFactory getDAOFactory(int qualFabrica) {
        switch (qualFabrica) {
            case ORACLE:
                return new OracleDAOFactory();
            case HASHMAP:
                return new HashMapDAOFactory();
            case RAF:
                return new RAFDAOFactory();
            default:
                return null;
        }
    }
}
