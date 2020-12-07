package RepoImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos{

    private int ID;
    private String nombre;
    private double cantidad;
    private String descripcion;


}
