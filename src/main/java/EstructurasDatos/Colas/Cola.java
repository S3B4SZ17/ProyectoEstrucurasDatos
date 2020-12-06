package EstructurasDatos.Colas;

public class Cola {
    private NodoCola primero;
    private NodoCola ultimo;
    private final int size;
    private int contador = 0;


    public Cola(int size) {
        this.size = size;
    }
    public Cola() {
        this.size = 20;
    }

    public void agregarCola(NodoCola elemento){
        if(vacia()){
            primero = elemento;
            ultimo = elemento;
            contador++;
        }else{
            if(!llena()){
                ultimo.setAtras(elemento);
                ultimo = elemento;
                contador++;
            }else{
                System.out.println("La cola esta llena, solo se pueden agregar "+getSize()+" elementos");
            }


        }
    }

    public int atiende(){
        int aux = 0;
        if (!vacia()){
            aux = primero.getNumero();
            primero = primero.getAtras();
            contador--;
            return aux;
        }
        else{
            System.out.println("La cola esta vacia");
            return 0;
        }
    }

    public String toString() {
        String str = "";
        NodoCola temp;
        temp = primero;
        while (temp != null) {
            str += "\t" + temp.getNumero();
            temp = temp.getAtras();
        }
        return str;
    }

    public boolean vacia(){
        if (primero == null) return true;
        else return false;
    }

    public boolean llena(){
        if (contador == getSize()) return true;
        else return false;

    }

    public int getSize() {
        return size;
    }


    public int[] recorreColaLlenaMatriz(){
        int[] matriz = new int[getSize()];
        NodoCola aux = primero;
        int i = 0;
        while (aux!=null){
            matriz[i] = aux.getNumero();
            aux = aux.getAtras();
            i++;
        }

        return matriz;

    }
}
