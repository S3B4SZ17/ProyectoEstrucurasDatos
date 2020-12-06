package Repository;

import RepoImpl.Clientes;

import java.util.List;

public interface RepoClientes {
    void guardarCliente(Clientes cliente);
    Clientes getCliente(int id);
    void modificaCliente(int id);
    boolean borrarCliente(int id);
    List<Clientes> getAllClientes();
}
