package EstructurasDatos.Listas;

import RepoImpl.Productos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NodoProducto {
    private Productos productos;
    private NodoProducto next;

    public NodoProducto(Productos productos) {
        this.productos = productos;
    }
}
