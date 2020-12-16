/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepoImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Leo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private TipoUsuario rol; 
    
    @Override
    public String toString() {
        return "{" +
                " Id = " + id +
                ", nombre = '" + nombre + '\'' +
                ", apellidos = " + apellidos +
                ", correo = " + correo +
                ", direccion = '" + direccion + '\'' +
                ", telefono = '" + telefono + '\'' +
                ", Tipo de Usuario: = '" + rol.toString() + '\'' +
                '}'+"\n";
    }
    
    






}
