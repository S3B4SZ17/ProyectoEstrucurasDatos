package EstructurasDatos.Pilas;

import RepoImpl.Productos;

public class NodoPila {
    private Productos productos;
    private NodoPila nodoPila;

    public NodoPila(Productos productos) {
        this.productos = productos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public NodoPila getNodoPila() {
        return nodoPila;
    }

    public void setNodoPila(NodoPila nodoPila) {
        this.nodoPila = nodoPila;
    }

    @Override
    public String toString() {
        return "NodoPila{" +
                "productos=" + productos +
                '}';
    }
}
