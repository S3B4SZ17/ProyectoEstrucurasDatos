package EstructurasDatos.Listas;

import RepoImpl.Productos;

import javax.swing.*;

public class Lista {
    private NodoProducto cabeza;

    public void insertaProducto(Productos productos){
        if(cabeza == null){
            cabeza = new NodoProducto(productos);
        }
        else if(cabeza.getProductos().getId() > productos.getId()){
            NodoProducto aux = new NodoProducto(productos);
            aux.setNext(cabeza);
            cabeza = aux;
        }
        else {
            NodoProducto aux = cabeza;
            NodoProducto temp = new NodoProducto(productos);
            while (aux.getNext() != null && aux.getNext().getProductos().getId() < productos.getId() ){
                aux = aux.getNext();
            }
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }
    }


    public void elimina(int id){
        NodoProducto aux = cabeza;
        if(buscar(id) != null){
            if (aux.getProductos().getId() == id){
                aux = aux.getNext();
                cabeza = aux;
            }else{
                while (aux!=null && aux.getNext().getProductos().getId() < id ){
                    aux = aux.getNext();
                }
                aux.setNext(aux.getNext().getNext());
            }
        }else{
            JOptionPane.showConfirmDialog(null,"No se encontro ningun producto con ese ID");
        }


    }

    public Productos buscar(int id){
        Productos p;
        NodoProducto aux = cabeza;
        while (aux !=null){
            if (id == aux.getProductos().getId()){
                p = aux.getProductos();
                return p;
            }
            aux = aux.getNext();
        }

        return  null;

    }

    public void modifica(int id,Productos productos){
        NodoProducto aux = cabeza;
        if(buscar(id) != null) {
            while (aux != null) {
                if (id == aux.getProductos().getId()) {
                    aux.getProductos().setPrecio(productos.getPrecio());
                    aux.getProductos().setCantidad(productos.getCantidad());
                    return;
                }
                aux = aux.getNext();
            }
        }else{
            JOptionPane.showConfirmDialog(null,"No se encontro ningun producto con ese ID");
        }

    }

    public void ordenaAlfabeticamente(Productos  productos){

        if(cabeza == null){
            cabeza = new NodoProducto(productos);
        }
        else if (cabeza.getProductos().getNombre().compareToIgnoreCase(productos.getNombre()) >= 0 ){
            NodoProducto aux = new NodoProducto(productos);
            aux.setNext(cabeza);
            cabeza = aux;
        }
        else if (cabeza.getProductos().getNombre().compareToIgnoreCase(productos.getNombre()) < 0){
            NodoProducto aux = cabeza;
            NodoProducto temp = new NodoProducto(productos);
            while (aux.getNext() != null && aux.getNext().getProductos().getNombre().compareToIgnoreCase(productos.getNombre()) < 0 ){
                aux = aux.getNext();
            }
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }


    }


    public int cantidadElementos(){
        int cantidad = 0;
        NodoProducto aux = cabeza;

        while (aux != null){
            cantidad++;
            aux = aux.getNext();
        }

        return cantidad;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
