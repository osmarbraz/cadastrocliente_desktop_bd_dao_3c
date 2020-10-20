package dao.cliente;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import dao.RAFDAOFactory;
import entidade.Cliente;

/**
 * Implementa a persitência para cliente utilizando Arquivo de Acesso
 * Aleat�rio(RandomAcessFile).
 *
 * @author osmarbraz
 * @version 1.0
 * @updated 06-nov-2013 10:05:17
 */
public class RAFClienteDAO extends RAFDAOFactory implements ClienteDAO {

    private RandomAccessFile arquivo;

    public RAFClienteDAO() {
        abrirArquivo();
    }

    public void finalize() throws Throwable {
        try {
            fecharArquivo();
        } finally {
            super.finalize();
        }
    }

    private void abrirArquivo() {
        try {
            File NomeArquivo = new File("cliente.dat");
            arquivo = new RandomAccessFile(NomeArquivo, "rw");
        } catch (IOException e) {
            System.out.println("Problema em abrir o arquivo!");
        }
    }

    private void fecharArquivo() {
        try {
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Não foi possível fechar arquivo");
        }
    }

    public boolean inserir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            if (procurarCodigo(cliente.getClienteId() + "") == -1) {
                try {
                    RAFRegistroCliente registro = new RAFRegistroCliente();
                    registro.setClienteId(Integer.parseInt(cliente.getClienteId()));
                    registro.setNome(cliente.getNome());
                    registro.setCpf(cliente.getCpf());
                    arquivo.seek(arquivo.length());
                    registro.escrita(arquivo);
                    return true;
                } catch (IOException e) {
                    System.out.println("Erro no Inserir!");
                }
            } else {
                System.out.println("Violou a chave primaria clienteId!");
                return false;
            }
        }
        return false;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List getLista() {
        List lista = new LinkedList();
        RAFRegistroCliente registro = new RAFRegistroCliente();
        try {
            arquivo.seek(0);

            while (arquivo.getFilePointer() < arquivo.length()) {
                registro.leitura(arquivo);
                Cliente cli = new Cliente();
                cli.setClienteId(registro.getClienteId());
                cli.setNome(registro.getNome());
                cli.setCpf(registro.getCpf());
                lista.add(cli);
            }
        } catch (EOFException eof) {
        } catch (IOException io) {
        }
        return lista;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List aplicarFiltro(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            List lista = new LinkedList();
            //Filtro para clienteId
            if (cliente.getClienteId() != null) {
                try {
                    arquivo.seek(0);
                    RAFRegistroCliente registro = new RAFRegistroCliente();

                    while (arquivo.getFilePointer() < arquivo.length()) { //Avança enquanto tiver objetos
                        registro.leitura(arquivo);
                        if (registro.getClienteId().equalsIgnoreCase(cliente.getClienteId())) {
                            Cliente cli = new Cliente();
                            cli.setClienteId(registro.getClienteId());
                            cli.setNome(registro.getNome());
                            cli.setCpf(registro.getCpf());
                            lista.add(cli);
                        }
                    }
                } catch (EOFException eof) {
                } catch (IOException io) {
                }
            } else {
                //Filtro para nome
                if (cliente.getNome() != null) {
                    try {
                        arquivo.seek(0);
                        RAFRegistroCliente registro = new RAFRegistroCliente();
                        while (arquivo.getFilePointer() < arquivo.length()) { //Avan�a enquanto tiver objetos
                            registro.leitura(arquivo);
                            if (registro.getNome().equalsIgnoreCase(cliente.getNome())) {
                                Cliente cli = new Cliente();
                                cli.setClienteId(registro.getClienteId());
                                cli.setNome(registro.getNome());
                                cli.setCpf(registro.getCpf());
                                lista.add(cli);
                            }
                        }
                    } catch (EOFException eof) {
                    } catch (IOException io) {
                    }
                } else {
                    //Filtro para CPF
                    if (cliente.getCpf() != null) {
                        try {
                            arquivo.seek(0);
                            RAFRegistroCliente registro = new RAFRegistroCliente();
                            while (arquivo.getFilePointer() < arquivo.length()) { //Avan�a enquanto tiver objetos
                                registro.leitura(arquivo);
                                if (registro.getCpf().equalsIgnoreCase(cliente.getCpf())) {
                                    Cliente cli = new Cliente();
                                    cli.setClienteId(registro.getClienteId());
                                    cli.setNome(registro.getNome());
                                    cli.setCpf(registro.getCpf());
                                    lista.add(cli);
                                }
                            }
                        } catch (EOFException eof) {
                        } catch (IOException io) {
                        }
                    }
                }
            }
            return lista;
        } else {
            return null;
        }
    }

    public int alterar(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            String chave = cliente.getClienteId() + "";
            int pos = -1;
            RAFRegistroCliente registro = new RAFRegistroCliente();
            try {
                pos = procurarCodigo(chave);
                if (pos != -1) {
                    int cont = 0;
                    arquivo.seek(pos * registro.getTamanho());
                    registro.setClienteId(cliente.getClienteId());
                    registro.setNome(cliente.getNome());
                    registro.setCpf(cliente.getCpf());
                    registro.escrita(arquivo);
                } else {
                    System.out.println("ClienteId não encontrado");
                }
            } catch (EOFException eof) {
            } catch (IOException io) {
            }
            return 1;
        }
        return 0;
    }

    private int procurarCodigo(String cod) {
        int pos = -1;
        int cont = 0;
        RAFRegistroCliente registro = new RAFRegistroCliente();
        try {
            arquivo.seek(0);
            while (arquivo.getFilePointer() < arquivo.length()) {
                registro.leitura(arquivo);
                if (registro.getClienteId().equalsIgnoreCase(cod)) {
                    pos = cont;
                }
                cont = cont + 1;
            }
        } catch (EOFException eof) {
        } catch (IOException io) {
        }
        return pos;
    }

    public int excluir(Object obj) {
        if (obj != null) {
            Cliente cliente = (Cliente) obj;
            String chave = cliente.getClienteId() + "";
            int pos = -1;
            RAFRegistroCliente registro = new RAFRegistroCliente();
            try {
                pos = procurarCodigo(chave);
                if (pos != -1) {
                    int cont = 0;
                    arquivo.seek(pos * registro.getTamanho());
                    registro.setClienteId(-1);
                    registro.setNome("");
                    registro.setCpf("");
                    registro.escrita(arquivo);
                } else {
                    System.out.println("ClienteId não encontrado");
                }
            } catch (EOFException eof) {
            } catch (IOException io) {
            }
            return 1;
        }
        return 0;
    }
}
