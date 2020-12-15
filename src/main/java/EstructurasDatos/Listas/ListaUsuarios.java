package EstructurasDatos.Listas;

import RepoImpl.TipoUsuario;
import RepoImpl.Usuarios;

import javax.swing.*;

public class ListaUsuarios {

 NodoListaUsuarios cabeza;   

 public boolean esVacia() {
        return cabeza == null;
    }
 
 public void AgregarUsuario(Usuarios usuario){
     
    if(cabeza==null){
        cabeza = new NodoListaUsuarios(usuario);
    }else if(usuario.getId()<cabeza.getDatos().getId()){
        
        NodoListaUsuarios aux = new NodoListaUsuarios(usuario);
        aux.setNext(cabeza);
        cabeza=aux;    
    }else if(cabeza.getNext()==null){
        cabeza.setNext(new NodoListaUsuarios(usuario));
    }else{
        
        NodoListaUsuarios aux = cabeza;
        
       while(aux.getNext()!=null && aux.getNext().getDatos().getId()< usuario.getId()){
           
           aux=aux.getNext();
           NodoListaUsuarios temp= new NodoListaUsuarios(usuario);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
       } 
       
    } 

 }
         
  public String eliminarUsuario(int codUsuario) {
        String result = "";
        NodoListaUsuarios anterior = null;
        NodoListaUsuarios actual = cabeza;
        NodoListaUsuarios aux = null;
        while (actual != null) {
            if (actual.getDatos().getId() == codUsuario) {
                if (anterior == null) {
                    aux = actual.getNext();
                    actual = actual.getNext();
                    result = "Se ha eliminado correctamente.";
                    break;
                } else if (actual.getNext()== null) {
                    aux = anterior;
                    aux.setNext(null);
                    result = "Se ha eliminado correctamente.";
                    break;
                } else {
                    aux = actual.getNext();
                    anterior.setNext(aux);
                    actual.setNext(null);
                    result = "Se ha eliminado correctamente.";
                    break;
                }
            }
            result = "El usuario no existe.";
            anterior = actual;
            actual = actual.getNext();
        }
        return result;
    }   
    
    public void actualizarUsuario(int ID, NodoListaUsuarios nodo) {
        Usuarios user;
        if (nodo != null) {
            if (nodo.getDatos().getId() == ID) {
                user = nodo.getDatos();
                int opcionActualizar;
                do {
                    opcionActualizar = Integer.parseInt(JOptionPane.showInputDialog(
                            "----- ACTUALIZAR USUARIO ----- \n"
                            + "1. Tipo Usuario \n"
                            + "2. Correo \n"
                            + "3. Direccion \n"
                            + "4. Telefono \n"
                            + "----------------------------------"));
                    switch (opcionActualizar) {
                        case 1:
                            int tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Digite el tipo de usuario \n1. Empleado \n2. Cliente"));
                            if (tipoUsuario > 0 && tipoUsuario < 3) {
                                user.setRol(tipoUsuario ==1 ? TipoUsuario.EMPLEADO : TipoUsuario.CLIENTE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Opci�n incorrecta.");
                            }
                            break;
                        case 2:
                            String correo = JOptionPane.showInputDialog("Digite el nuevo correo: ");
                            user.setCorreo(correo);
                            break;
                        case 3:
                            String direccion = JOptionPane.showInputDialog("Digite la nueva direccion: ");
                            user.setDireccion(direccion);
                            break;   
                         case 4:
                            String tel = JOptionPane.showInputDialog("Digite el nuevo telefono: ");
                            user.setTelefono(tel);
                            break;    
                        case 5:
                    }
                } while (opcionActualizar > 0 && opcionActualizar < 2);
                JOptionPane.showMessageDialog(null, "Actualizaci�n completada exitosamente.");
            } else {
                actualizarUsuario(ID, nodo.getNext());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existen usuarios con este c�digo");
        }
    } 
    
    
      public String imprimir(NodoListaUsuarios nodo) {
        String usuarios = "";
        if (esVacia()) {
            usuarios = "No hay usuarios agregados.";
        } else if (nodo == null) {
            usuarios = "";
        } else {
            usuarios += "C�digo de usuario: " + nodo.getDatos().getId() + "\nNombre de usuario: " + nodo.getDatos().getNombre() + "\nApellido de usuario: " + nodo.getDatos().getApellidos() + "\nTipo de usuario: " + nodo.getDatos().getRol().toString()+"\nCorreo del usuario" + nodo.getDatos().getCorreo() + "\nDireccion del usuario:"+ nodo.getDatos().getDireccion()+"\nTelefono del usuario:"+ nodo.getDatos().getTelefono()+"\n-------------------\n" + imprimir(nodo.getNext());
        }
        return usuarios;
    }

    public Usuarios existe(int id) {       //METODO PARA VERIFICAR SI UN USUARIO ESTA REGISTRADO EN EL SISTEMA
        Usuarios miUsuario = null;
        NodoListaUsuarios aux = cabeza;
        if (aux.getNext() == null) {
            if (aux.getDatos().getId() == id) {
                miUsuario = aux.getDatos();
            }
        }
        while (aux != null) {
            if (aux.getDatos().getId() == id) {
                miUsuario = aux.getDatos();
                break;
            }
            aux = aux.getNext();
        }
        return miUsuario;
    }

    @Override
    public String toString() {
        return "ListaUsuarios{" + cabeza +
                '}';
    }
}
