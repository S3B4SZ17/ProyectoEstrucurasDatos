package EstructurasDatos.Pilas;


import RepoImpl.Productos;

public class Pila {
    private NodoPila pila;

    public void push(NodoPila producto){
        producto.setNodoPila(pila);
        pila = producto;

    }

    public NodoPila getPila(){
        return pila;
    }

    public Productos pop(){
        Productos aux = null;
        if (!vacia()){
            aux = pila.getProductos();
            pila = pila.getNodoPila();
            return aux;

        }else{
            System.out.println("La pila esta vacia");
            return null;
        }
    }



    public boolean vacia(){
        if(pila == null){
            return true;
        }
        else{
            return false;
        }

    }

    public String toString() {
        String numero = "";
        NodoPila aux = pila;
        while (aux!=null){
            numero += "\t"+ aux.getProductos().getNombre();
            aux = aux.getNodoPila();

        }
        return numero;
    }


}
