package EstructurasDatos.Colas;

import EstructurasDatos.Listas.Lista;
import RepoImpl.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodoCola {
    private int factura;
    private Usuarios cliente;
    private Lista productos;
    private NodoCola nodoCola;

    public NodoCola(int factura, Usuarios cliente, Lista productos) {
        this.factura = factura;
        this.cliente = cliente;
        this.productos = productos;
    }

    public NodoCola getAtras() {
        return nodoCola;
    }

    public void setAtras(NodoCola cola) {
        this.nodoCola = cola;
    }


}
