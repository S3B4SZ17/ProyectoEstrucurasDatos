package RepoImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos{

    private int Id;
    private String nombre;
    private double precio;
    private double cantidad;
    private String descripcion;

    public Productos(double precio, double cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                " Id = " + Id +
                ", nombre = '" + nombre + '\'' +
                ", precio = " + precio +
                ", cantidad = " + cantidad +
                ", descripcion = '" + descripcion + '\'' +
                '}'+"\n";
    }
}
