package EstructurasDatos.Listas;

import RepoImpl.Usuarios;

public class NodoListaUsuarios {
    
   private Usuarios datos;
   private NodoListaUsuarios next;

    public NodoListaUsuarios(Usuarios datos) {
        this.datos = datos;
    }

    public Usuarios getDatos() {
        return datos;
    }

    public void setDatos(Usuarios datos) {
        this.datos = datos;
    }

    public NodoListaUsuarios getNext() {
        return next;
    }

    public void setNext(NodoListaUsuarios next) {
        this.next = next;
    }  
}
