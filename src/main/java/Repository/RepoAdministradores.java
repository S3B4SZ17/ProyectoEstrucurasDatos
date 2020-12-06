package Repository;

import RepoImpl.Administradores;

import java.util.List;

public interface RepoAdministradores {
    void guardarAdministrador(Administradores administrador);
    Administradores getAdministrador(int id);
    void modificaProducto(int id);
    boolean borrarAdministrador(int id);
    List<Administradores> getAllAdministradores();
}
