package Repository;

import RepoImpl.Productos;

import java.util.List;

public interface RepoProductos {
    void guardarProducto(Productos producto);
    Productos getProducto(int id);
    void modificaProducto(int id);
    boolean borrarProducto(int id);
    List<Productos> getAllProductos();


}
