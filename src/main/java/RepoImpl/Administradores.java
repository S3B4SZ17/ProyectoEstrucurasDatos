package RepoImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administradores {

    private int badge;
    private String nombre;
    private String apellidos;
    private String puesto;

}
