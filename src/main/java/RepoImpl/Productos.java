package RepoImpl;

import Repository.RepoProductos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos implements RepoProductos {

    private int ID;
    private String nombre;
    private double cantidad;
    private String descripcion;

    public void guardarProducto(Productos producto) {

    }

    public Productos getProducto(int id) {
        return null;
    }

    public void modificaProducto(int id) {

    }

    public boolean borrarProducto(int id) {
        return false;
    }

    public List<Productos> getAllProductos() {
        return null;
    }
}
