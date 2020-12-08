package Main;

import EstructurasDatos.Listas.Lista;
import EstructurasDatos.Listas.NodoProducto;
import RepoImpl.Productos;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        menuProductos();
    }

    public static void menuProductos(){
        Lista listaProductos = new Lista();
        int opcionMenu;
        do{
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(
                    "************* Modulo dde Inventarios ***************\n"+
                            "1. Insertar nuevo producto\n" +
                            "2. Buscar producto por ID\n" +
                            "3. Eliminar Producto\n" +
                            "4. Modificar producto\n" +
                            "5.	Mostrar todos los productos\n"+
                            "6.	Salir\n\n"+
                            "Digite la opción que desea ejecutar:\n" +
                            "***************************************\n"));

            switch(opcionMenu){

                case 1:
                    listaProductos.insertaProducto(
                            new Productos( generaConsecutivo(listaProductos),
                                    JOptionPane.showInputDialog("Ingese el nonbre del producto"),
                                    Double.parseDouble(JOptionPane.showInputDialog("Ingese el precio del Producto")),
                                    Double.parseDouble(JOptionPane.showInputDialog("Ingese la cantidad (kg/unidades) del Producto")),
                                    JOptionPane.showInputDialog("Ingrese una descripcion pra el producto")));
                    opcionMenu = 0;
                    break;
                case 2:
                    Productos p = null;
                    NodoProducto aux = listaProductos.getCabeza();
                    Productos producto = listaProductos.buscarR(Integer.parseInt(JOptionPane.showInputDialog("Ingese el ID(numeros) del Producto")),p,aux);
                    if (producto != null){
                        JOptionPane.showConfirmDialog(null,producto);
                    }
                    else{
                        JOptionPane.showConfirmDialog(null,"No se encontro ningun producto con ese ID");
                    }

                    opcionMenu = 0;
                    break;
                case 3:
                    listaProductos.elimina(Integer.parseInt(JOptionPane.showInputDialog("Ingese el ID (numero) del Producto que desea eliminar")));
                    opcionMenu = 0;

                    break;
                case 4:
                    listaProductos.modifica(Integer.parseInt(JOptionPane.showInputDialog("Ingese el ID (numero) del Producto que desea modificar")),
                            new Productos(
                                    Double.parseDouble(JOptionPane.showInputDialog("Ingese el nuevo precio del Producto")),
                                    Double.parseDouble(JOptionPane.showInputDialog("Ingese la nueva cantidad (kg/unidades) del Producto"))));

                   opcionMenu = 0;
                    break;
                case 5:
                    JOptionPane.showConfirmDialog(null, listaProductos);
                    break;

            }


        }
        while(opcionMenu != 6);
    }
    private static int generaConsecutivo(Lista lista){
        int consecutivo = 1;
        NodoProducto aux = lista.getCabeza();
        while (aux != null){
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            consecutivo = aux.getProductos().getId() + 1;
            return consecutivo;
        }

        return consecutivo;
    }
}
