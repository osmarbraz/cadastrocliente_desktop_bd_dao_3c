package dao.cliente;

/**
 * Armazena os metadados para a implementação em oracle.
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 14-nov-2012 16:08:58
 */
public interface OracleClienteMetaDados {

    /**
     * string com o nome da tabela usada no banco
     */
    public static final String TABLE = "CLIENTE";

    /**
     * vetor de string com as chaves da tabela
     */
    public static final String[] PK = {"CLIENTEID"};

    /**
     * string com os campos para serem utilizados com insert
     */
    public static String METADADOSINSERT = "CLIENTEID, NOME, CPF ";

    /**
     * Retorna uma string com os campos para serem utilizados com select
     */
    public static String METADADOSSELECT
            = TABLE + ".CLIENTEID, "
            + TABLE + ".NOME, "
            + TABLE + ".CPF";

    // "TO_CHAR (" + TABLE + ".DATA_NASCIMENTO,'dd/mm/yyyy')CLIENTE_DATA_NASCIMENTO, " + 
}
