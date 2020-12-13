package EstructurasDatos.Colas;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cola {
    private NodoCola primero;
    private NodoCola ultimo;



    public void agregarCola(NodoCola elemento){
        if(vacia()){
            primero = elemento;
            ultimo = elemento;

        }else{
            ultimo.setAtras(elemento);
            ultimo = elemento;
        }
    }

    public int atiende(){
        int aux = 0;
        if (!vacia()){
            aux = primero.getFactura();
            primero = primero.getAtras();
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
            str += "\t" + temp.getFactura();
            temp = temp.getAtras();
        }
        return str;
    }

    public boolean vacia(){
        if (primero == null) return true;
        else return false;
    }



}
