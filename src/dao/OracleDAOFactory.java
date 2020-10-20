package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import dao.cliente.ClienteDAO;
import dao.cliente.OracleClienteDAO;

/**
 * Implementa a fonte de dado para persistência em memória utilizando SGBD
 * Oracle.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 14-nov-2012 16:08:58
 */
public class OracleDAOFactory extends DAOFactory {

    private String driverClass;
    private String jdbcURL;
    private String usuario;
    private String senha;

    /**
     * Construtor sem argumentos.
     */
    public OracleDAOFactory() {
        setDriverClass("oracle.jdbc.driver.OracleDriver");
        setJdbcURL("jdbc:oracle:thin:@localhost:1521:XE");
        setUsuario("cliente");
        setSenha("cliente");
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna uma conex�o aberta para as subclasses da f�brica para oracle.
     *
     * @return Connection Um objeto com a conex�o aberta
     * @exception SQLException
     */
    protected Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(getDriverClass());
            con = DriverManager.getConnection(getJdbcURL(), getUsuario(), getSenha());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw e;
        }
        return con;
    }

    /**
     * Operaçãp para prepara a string que ser� enviada ao banco de dados Se ela
     * possui uma ' será duplicada para anular o efeito de sql injetado
     *
     * @return String texto com ' duplicado
     * @param valor string a ser preparada para envio ao banco de dados
     */
    protected String preparaSQL(String valor) {
        if (valor != null) {
            return valor.replaceAll("\'", "''");
        } else {
            return "";
        }
    }

    /**
     * Concatena String baseado nos valores Strings de uma Collection
     *
     * @return String Com os literais conctatenados.
     *
     * @param separator
     * @param collection
     */
    public String implode(String separator, @SuppressWarnings("rawtypes") Collection collection) {
        StringBuffer textBufferReturn = new StringBuffer();
        @SuppressWarnings("rawtypes")
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String text = (String) it.next();
            textBufferReturn.append(text);
            if (it.hasNext()) {
                textBufferReturn.append(separator);
            }
        }
        return textBufferReturn.toString();
    }

    /**
     * Retorna uma Cliente DAO
     *
     * @return ClienteDAO Um DAO para cliente
     */
    public ClienteDAO getClienteDAO() {
        return new OracleClienteDAO();
    }
}
