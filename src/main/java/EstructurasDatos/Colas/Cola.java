package EstructurasDatos.Colas;

import EstructurasDatos.Listas.Lista;
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

    public Lista atiende(){
        Lista aux = null;
        if (!vacia()){
            aux = primero.getProductos();
            primero = primero.getAtras();
            return aux;
        }
        else{
            System.out.println("La cola esta vacia");
            return null;
        }
    }

    public String toString() {
        String str = "";
        NodoCola temp;
        temp = primero;
        while (temp != null) {
            str += "\t" + temp;
            temp = temp.getAtras();
        }
        return str;
    }

    public boolean vacia(){
        if (primero == null) return true;
        else return false;
    }
    
    public Lista buscar(int fact){
        NodoCola aux= primero;
        Lista aux2=null;
        while(aux!=null){
            if(aux.getFactura()==fact){
                aux2=aux.getProductos();
                return aux2;
            }
            else{
                aux=aux.getAtras();
            }
        }
        
        //OptionPane.showConfirmDialog(null,"No se encontro la factura");
        return aux2;

    }
}