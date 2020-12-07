package RepoImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes  {

    private String cedula;
    private String nombre;
    private String Apellido;
    private String ocupacion;


}
