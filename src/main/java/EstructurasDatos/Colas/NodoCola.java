package EstructurasDatos.Colas;

public class NodoCola {
    private int numero;
    private NodoCola nodoCola;

    public NodoCola(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public NodoCola getAtras() {
        return nodoCola;
    }

    public void setAtras(NodoCola cola) {
        this.nodoCola = cola;
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }
}
