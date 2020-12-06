package RepoImpl;

import Repository.RepoClientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes implements RepoClientes {

    private String cedula;
    private String nombre;
    private String Apellido;
    private String ocupacion;


    public void guardarCliente(Clientes cliente) {

    }

    public Clientes getCliente(int id) {
        return null;
    }

    public void modificaCliente(int id) {

    }

    public boolean borrarCliente(int id) {
        return false;
    }

    public List<Clientes> getAllClientes() {
        return null;
    }
}
