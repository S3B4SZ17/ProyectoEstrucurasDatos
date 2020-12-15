package Main;

import EstructurasDatos.Colas.Cola;
import EstructurasDatos.Colas.NodoCola;
import EstructurasDatos.Listas.Lista;
import EstructurasDatos.Listas.ListaUsuarios;
import EstructurasDatos.Listas.NodoProducto;
import RepoImpl.Productos;
import RepoImpl.TipoUsuario;
import RepoImpl.Usuarios;

import javax.swing.*;

public class metodosMenu {

    public Lista menuProductos(Lista listaProductos){
        int opcionMenu = 0;

        do {
            try {
                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(
                        "************* Modulo de Inventarios ***************\n" +
                                "1. Insertar nuevo producto\n" +
                                "2. Buscar producto por ID\n" +
                                "3. Eliminar Producto\n" +
                                "4. Modificar producto\n" +
                                "5.	Mostrar todos los productos\n" +
                                "6.	Volver al menu Principal\n\n" +
                                "Digite la opción que desea ejecutar:\n" +
                                "***************************************\n"));

                switch (opcionMenu) {

                    case 1:
                        listaProductos.insertaProducto(
                                new Productos(generaConsecutivoProducto(listaProductos),
                                        JOptionPane.showInputDialog("Ingese el nonbre del producto"),
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingese el precio del Producto")),
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingese la cantidad (kg/unidades) del Producto")),
                                        JOptionPane.showInputDialog("Ingrese una descripcion pra el producto")));
                        opcionMenu = 0;
                        break;
                    case 2:
                        Productos p = null;
                        NodoProducto aux = listaProductos.getCabeza();
                        Productos producto = listaProductos.buscarR(Integer.parseInt(JOptionPane.showInputDialog("Ingese el ID(numeros) del Producto")), p, aux);
                        if (producto != null) {
                            JOptionPane.showConfirmDialog(null, producto);
                        } else {
                            JOptionPane.showConfirmDialog(null, "No se encontro ningun producto con ese ID");
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


            }catch (NumberFormatException numberFormatException){
                JOptionPane.showConfirmDialog(null,"Dato ingresado incorrectamente");
            }
        }
        while(opcionMenu != 6);
        return listaProductos;
    }

    private int generaConsecutivoProducto(Lista lista){
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
    private int generaConsecutivoFactura(Lista lista){
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

    public Cola menuPedidos(Cola pedidos, Lista listaProductos, ListaUsuarios listaClientes){

        int opcionMenu = 0;

        do {
            try {
                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(
                        "************* Modulo de Ventas ***************\n" +
                                "1. Ver Productos\n" +
                                "2. Realizar compra\n" +
                                "3. Ver ordenes de compra\n"+
                                "4. Volver al menu Principal\n\n" +
                                "Digite la opción que desea ejecutar:\n" +
                                "***************************************\n"));

                switch (opcionMenu) {

                    case 1:
                        JOptionPane.showConfirmDialog(null, listaProductos);
                        opcionMenu = 0;
                        break;
                    case 2:
                        Lista productos = new Lista();
                        int continuar =0;
                        do{
                            Productos p = null;
                            NodoProducto aux = listaProductos.getCabeza();
                            Productos producto = listaProductos.buscarR(Integer.parseInt(JOptionPane.showInputDialog("Ingese el ID(numeros) del Producto para gregar a la orden")), p, aux);
                            if (producto != null) {
                                producto.setCantidad(Double.parseDouble(JOptionPane.showInputDialog("Digite la cantidad del producto")));
                                productos.insertaProducto(producto);
                            } else {
                                JOptionPane.showConfirmDialog(null, "No se encontro ningun producto con ese ID");
                            }
                            continuar = Integer.parseInt(JOptionPane.showInputDialog("Desea agregar mas productos? \n"+
                                    "1. Si\n"+
                                    "2. No\n"));
                        }while (continuar != 2);

                        Usuarios cliente = listaClientes.existe(Integer.parseInt(JOptionPane.showInputDialog("Digite el usuario")));
                        pedidos.agregarCola(new NodoCola(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de factura")), cliente
                                //listaClientes.buscarCliente(Integer.parseInt("Digite el ID del cleinte"));se tiene que buscar por ID un usuario para asi poder generar la compra
                                ,productos));

                        opcionMenu = 0;
                        break;
                    case 3:
                        JOptionPane.showConfirmDialog(null, pedidos);
                        opcionMenu = 0;
                        break;
                }


            }catch (NumberFormatException numberFormatException){
                JOptionPane.showConfirmDialog(null,"Dato ingresado incorrectamente");
            }
        }
        while(opcionMenu != 4);

        return pedidos;

    }

    public ListaUsuarios menuUsuarios(ListaUsuarios usuario,Lista listaProductos,Cola pedidos){
        int opcion =0;
        int tipoUsuario;
        int menuUsuarios;

        tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                "----------BIENVENIDO----------\n"
                        +"1) Administrador \n"
                        +"2) Cliente \n"));

        JOptionPane.showInputDialog("Digite la contrase�a");


        if(tipoUsuario==1){

            int menuAdmin = 0;
            do {

                menuAdmin = Integer.parseInt(JOptionPane.showInputDialog(
                        "----------BIENVENIDO ADMINISTRADOR----------\n"
                                + "1)Administrar usuarios \n"
                                + "2)Administrar inventario \n"
                                + "3)Volver al menu de inicio \n"// volver al menu, para seleccionar cliente
                                + "--------------------------------------------"));

                switch (menuAdmin) {

                    case 1:

                        do {

                            menuUsuarios = Integer.parseInt(JOptionPane.showInputDialog(
                                    "----------BIENVENIDO ADMINISTRADOR----------\n"
                                            + "1)Agregar nuevo usuario \n"
                                            + "2)Ver usuarios registrados \n"
                                            + "3)Eliminar un usuario registrado \n"
                                            +"4)Volver al menu de Admin \n"
                                            + "--------------------------------------------"));
                            switch (menuUsuarios) {

                                case 1:
                                    TipoUsuario tipo = null;
                                    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del nuevo usuario: "));
                                    String nombre = JOptionPane.showInputDialog("Digite el nombre del nuevo usuario: ");
                                    String apellido = JOptionPane.showInputDialog("Digite el apellido del nuevo usuario: ");
                                    String correo = JOptionPane.showInputDialog("Digite el correo del nuevo usuario: ");
                                    String direccion = JOptionPane.showInputDialog("Digite la direccion del nuevo usuario: ");
                                    String telefono = JOptionPane.showInputDialog("Digite el telefono del nuevo usuario: ");
                                    String contrasena = JOptionPane.showInputDialog("Digite la contrasena: ");
                                    boolean continuar = true;
                                    do {
                                        int rol = Integer.parseInt(JOptionPane.showInputDialog("Digite el rol del nuevo usuario: \n" +
                                                "1.CLIENTE \n" +
                                                "2. EMPLEADO \n"));
                                        if (rol == 1) {
                                            tipo = TipoUsuario.CLIENTE;
                                            continuar = false;
                                        } else if (rol == 2) {
                                            tipo = TipoUsuario.EMPLEADO;
                                            continuar = false;
                                        } else {
                                            JOptionPane.showConfirmDialog(null, "Valor agregado para el usuario incorrecto");
                                            continuar = true;
                                        }
                                    } while (continuar);


                                    usuario.AgregarUsuario(new Usuarios(id, nombre, apellido, correo, direccion, telefono, contrasena, tipo));
                                    menuUsuarios = 0;
                                    break;


                                case 2:

                                    JOptionPane.showConfirmDialog(null, usuario);
                                    menuUsuarios = 0;

                                    break;

                                case 3:

                                    usuario.eliminarUsuario(Integer.parseInt("Digite el ID del usuario que desea eliminar: "));
                                    menuUsuarios = 0;
                                    break;
                            }


                        } while (menuUsuarios != 4);
                        menuAdmin = 0;
                        break;


                    case 2://eliminar este

                        menuProductos(listaProductos);
                        menuAdmin = 0;

                        break;


                    case 3:

                        menuPedidos(pedidos,listaProductos, usuario);
                        menuAdmin = 0;

                        break;


                }

            }while(menuAdmin!=3);
            return usuario;



        }else{

            menuProductos(listaProductos);





            return usuario;
        }

    }
}
