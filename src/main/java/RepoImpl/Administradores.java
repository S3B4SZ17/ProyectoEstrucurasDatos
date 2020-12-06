package RepoImpl;

import Repository.RepoAdministradores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administradores implements RepoAdministradores {

    private int badge;
    private String nombre;
    private String apellidos;
    private String puesto;

    public void guardarAdministrador(Administradores administrador) {


    }

    public Administradores getAdministrador(int id) {
        return null;
    }

    public void modificaProducto(int id) {

    }

    public boolean borrarAdministrador(int id) {
        return false;
    }

    public List<Administradores> getAllAdministradores() {
        return null;
    }
}
