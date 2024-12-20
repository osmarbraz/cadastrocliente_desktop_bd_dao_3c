package dao.cliente;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.HashMapDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persitência para cliente utilizando HashMap.
 *
 * @author osmarbraz
 */
public class HashMapClienteDAO extends HashMapDAOFactory implements ClienteDAO {

    private static Map<String, Cliente> mapa;

    /**
     * Construtor sem argumentos.
     */
    public HashMapClienteDAO() {
        //Se o mapa estiver nulo instancia para armazenar os clientes
        if (mapa == null) {
            mapa = new HashMap<>();
        }
    }

    @Override
    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (tem == false) {
                mapa.put(cliente.getClienteId(), cliente);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (tem == true) {
                Cliente c = (Cliente) mapa.get(cliente.getClienteId());
                c.setNome(cliente.getNome());
                c.setCpf(cliente.getCpf());
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int excluir(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }

        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            boolean tem = mapa.containsKey(cliente.getClienteId());
            if (tem == true) {
                mapa.remove(cliente.getClienteId());
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List getLista() {
        List lista = new LinkedList();
        Iterator it = mapa.values().iterator();
        while (it.hasNext()) { //Avança enquanto tiver objetos
            Cliente c = (Cliente) it.next();
            lista.add(c);
        }
        return lista;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            List lista = new LinkedList();
            Iterator it = mapa.values().iterator();

            //Filtro para clienteId
            if (cliente.getClienteId() != null) {
                while (it.hasNext()) { //Avança enquanto tiver objetos
                    Cliente c = (Cliente) it.next();
                    if (c.getClienteId().equalsIgnoreCase(cliente.getClienteId())) {
                        lista.add(c);
                    }
                }
            } else {
                //Filtro para nome
                if (cliente.getNome() != null) {
                    while (it.hasNext()) { //Avança enquanto tiver objetos
                        Cliente c = (Cliente) it.next();
                        if (c.getNome().equalsIgnoreCase(cliente.getNome())) {
                            lista.add(c);
                        }
                    }
                } else {
                    //Filtro para CPF
                    if (cliente.getCpf() != null) {
                        while (it.hasNext()) { //Avança enquanto tiver objetos
                            Cliente c = (Cliente) it.next();
                            if (c.getCpf().equalsIgnoreCase(cliente.getCpf())) {
                                lista.add(c);
                            }
                        }
                    }
                }
            }

            return lista;
        } else {
            return null;
        }
    }
}
