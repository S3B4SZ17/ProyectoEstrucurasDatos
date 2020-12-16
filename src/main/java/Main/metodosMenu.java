package Main;

import EstructurasDatos.Colas.Cola;
import EstructurasDatos.Colas.NodoCola;
import EstructurasDatos.Listas.Lista;
import EstructurasDatos.Listas.ListaUsuarios;
import EstructurasDatos.Listas.NodoListaUsuarios;
import EstructurasDatos.Listas.NodoProducto;
import RepoImpl.Productos;
import RepoImpl.TipoUsuario;
import RepoImpl.Usuarios;

import javax.swing.*;

public class metodosMenu {

    public Lista menuProductos(Lista listaProductos) {
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
                                "Digite la opcion que desea ejecutar:\n" +
                                "***************************************\n"));

                switch (opcionMenu) {

                    case 1:
                        listaProductos.insertaProducto(
                                new Productos(generaConsecutivoProducto(listaProductos),
                                        JOptionPane.showInputDialog("Ingrese el nombre del producto"),
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto")),
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad (kg/unidades) del Producto")),
                                        JOptionPane.showInputDialog("Ingrese una descripcion para el producto")));
                        opcionMenu = 0;
                        break;
                    case 2:
                        Productos p = null;
                        NodoProducto aux = listaProductos.getCabeza();
                        Productos producto = listaProductos.buscarR(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID(numeros) del Producto")), p, aux);
                        if (producto != null) {
                            JOptionPane.showConfirmDialog(null, producto);
                        } else {
                            JOptionPane.showConfirmDialog(null, "No se encontro ningun producto con ese ID");
                        }

                        opcionMenu = 0;
                        break;
                    case 3:
                        listaProductos.elimina(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID (numero) del Producto que desea eliminar")));
                        opcionMenu = 0;

                        break;
                    case 4:
                        listaProductos.modifica(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID (numero) del Producto que desea modificar")),
                                new Productos(
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del Producto")),
                                        Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva cantidad (kg/unidades) del Producto"))));

                        opcionMenu = 0;
                        break;
                    case 5:
                        JOptionPane.showConfirmDialog(null, listaProductos);
                        break;

                }


            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showConfirmDialog(null, "Dato ingresado incorrectamente");
            }
        }
        while (opcionMenu != 6);
        return listaProductos;
    }

    private int generaConsecutivoProducto(Lista lista) {
        int consecutivo = 1;
        NodoProducto aux = lista.getCabeza();
        while (aux != null) {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            consecutivo = aux.getProductos().getId() + 1;
            return consecutivo;
        }

        return consecutivo;
    }

    private int generaConsecutivoFactura(Cola cola) {
        int consecutivo = 1;
        NodoCola aux = cola.getUltimo();
        if (aux == null) {
            return consecutivo;
        } else {
            consecutivo = aux.getFactura() + 1;
            return consecutivo;
        }


    }

    private int generaConsecutivoUsuario(ListaUsuarios lista) {
        int consecutivo = 1;
        NodoListaUsuarios aux = lista.getCabeza();
        while (aux != null) {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            consecutivo = aux.getDatos().getId() + 1;
            return consecutivo;
        }

        return consecutivo;
    }

    public Cola menuPedidos(Cola pedidos, Lista listaProductos, ListaUsuarios listaClientes) {

        int opcionMenu = 0;

        do {
            try {
                opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(
                        "************* Modulo de Ventas ***************\n" +
                                "1. Ver Productos\n" +
                                "2. Realizar Orden de Compra\n" +
                                "3. Buscar Orden de Compra\n" +
                                "4. Volver al menu Principal\n\n" +
                                "Digite la opcion que desea ejecutar:\n" +
                                "***************************************\n"));

                switch (opcionMenu) {

                    case 1:
                        JOptionPane.showConfirmDialog(null, listaProductos);
                        opcionMenu = 0;
                        break;
                    case 2:
                        Lista productos = new Lista();
                        int continuar = 0;
                        Productos producto = null;
                        Productos p = null;
                        NodoProducto aux = listaProductos.getCabeza();
                        do {

                            producto = listaProductos.buscarR(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID(numeros) del Producto para agregar a la orden")), p, aux);
                            if (producto != null) {
                                productos.insertaProducto(new Productos(producto.getId(), producto.getNombre(), producto.getPrecio(), (Double.parseDouble(JOptionPane.showInputDialog("Digite la cantidad del producto"))), producto.getDescripcion()));
                            } else {
                                JOptionPane.showConfirmDialog(null, "No se encontro ningun producto con ese ID");
                            }
                            continuar = Integer.parseInt(JOptionPane.showInputDialog("Desea agregar mas productos? \n" +
                                    "1. Si\n" +
                                    "2. No\n"));
                        } while (continuar != 2);


                        Usuarios cliente = listaClientes.buscar(Integer.parseInt(JOptionPane.showInputDialog("Digite el usuario")));
                        if (cliente == null) {
                            JOptionPane.showConfirmDialog(null, "No hay ningun cliente con este ID");
                            break;
                        }
                        pedidos.agregarCola(new NodoCola(generaConsecutivoFactura(pedidos), cliente, productos));
                        JOptionPane.showConfirmDialog(null, "Su numero de factura es " + pedidos.getUltimo().getFactura());

                        opcionMenu = 0;
                        break;
                    case 3:

                        Lista aux4 = pedidos.buscar(Integer.parseInt(JOptionPane.showInputDialog("Digite la factura que desea buscar")));
                        if (aux4 == null) {
                            JOptionPane.showConfirmDialog(null, "No existe una factura con ese numero");
                            break;
                        }
                        JOptionPane.showConfirmDialog(null, aux4);
                        opcionMenu = 0;
                        break;


                }


            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showConfirmDialog(null, "Dato ingresado incorrectamente");
            }
        }
        while (opcionMenu != 4);

        return pedidos;

    }

    public ListaUsuarios menuUsuarios(ListaUsuarios usuario, Lista listaProductos, Cola pedidos) {
        int opcion = 0;
        int tipoUsuario;
        int menuUsuarios;
        do {

            tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                    "----------BIENVENIDO----------\n"
                            + "1) Administrador \n"
                            + "2) Cliente \n"));


            switch (tipoUsuario) {
                case 1:

                    int menuAdmin = 0;
                    do {

                        menuAdmin = Integer.parseInt(JOptionPane.showInputDialog(
                                "----------BIENVENIDO ADMINISTRADOR----------\n"
                                        + "1)Administrar usuarios \n"
                                        + "2)Administrar inventario \n"
                                        + "3)Ordenes de Compra  \n"// volver al menu, para seleccionar cliente
                                        + "4)Enviar Pedido \n"
                                        + "5)Volver al menu de inicio \n"
                                        + "--------------------------------------------"));

                        switch (menuAdmin) {

                            case 1:

                                do {

                                    menuUsuarios = Integer.parseInt(JOptionPane.showInputDialog(
                                            "----------BIENVENIDO ADMINISTRADOR----------\n"
                                                    + "1)Agregar nuevo usuario \n"
                                                    + "2)Ver usuarios registrados \n"
                                                    + "3)Eliminar un usuario registrado \n"
                                                    + "4)Volver al menu de Admin \n"
                                                    + "--------------------------------------------"));
                                    switch (menuUsuarios) {

                                        case 1:
                                            TipoUsuario tipo = null;
                                            //int id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del nuevo usuario: "));
                                            String nombre = JOptionPane.showInputDialog("Digite el nombre del nuevo usuario: ");
                                            String apellido = JOptionPane.showInputDialog("Digite el apellido del nuevo usuario: ");
                                            String correo = JOptionPane.showInputDialog("Digite el correo del nuevo usuario: ");
                                            String direccion = JOptionPane.showInputDialog("Digite la direccion del nuevo usuario: ");
                                            String telefono = JOptionPane.showInputDialog("Digite el telefono del nuevo usuario: ");
                                            boolean continuar = true;
                                            do {
                                                int rol = Integer.parseInt(JOptionPane.showInputDialog("Digite el rol del nuevo usuario: \n"
                                                        + "1.CLIENTE \n"
                                                        + "2. EMPLEADO \n"));
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

                                            usuario.AgregarUsuario(new Usuarios(generaConsecutivoUsuario(usuario), nombre, apellido, correo, direccion, telefono, tipo));
                                            menuUsuarios = 0;
                                            break;

                                        case 2:

                                            JOptionPane.showConfirmDialog(null, usuario);
                                            menuUsuarios = 0;

                                            break;

                                        case 3:

                                            usuario.elimina(Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del usuario que desea eliminar: ")));
                                            menuUsuarios = 0;
                                            break;
                                    }

                                } while (menuUsuarios != 4);
                                menuAdmin = 0;
                                break;

                            case 2:

                                menuProductos(listaProductos);
                                menuAdmin = 0;

                                break;

                            case 3:
                                JOptionPane.showConfirmDialog(null, pedidos);
                                menuAdmin = 0;
                                break;


                            case 4:
                                Lista aux = pedidos.atiende();
                                JOptionPane.showConfirmDialog(null, aux);
                                menuAdmin = 0;
                                break;

                        }

                    } while (menuAdmin != 5);

                    tipoUsuario = 0;
                    break;
                case 2:

                    menuPedidos(pedidos, listaProductos, usuario);
                    break;


            }

        } while (tipoUsuario != 3);

        return usuario;
    }
}
