/**
 * La clase Producto en un CRUD (Crear, Leer, Actualizar, Eliminar) representa un modelo que mapea los datos de una
 * tabla en la base de datos, como en este caso, la tabla producto
 * 1.0 Definir la estructura básica de la clase  * La clase Producto debe contener los mismos campos que la tabla
 *    producto en la base de datos.
 * 2.0 xxx- Declarar los atributos  * Los atributos deben coincidir con los campos de la tabla
 *     private int id;           // Mapea el campo 'id' en la tabla.
 *     private String nombre;    // Mapea el campo 'nombre'.
 *     private double precio;    // Mapea el campo 'precio'.
 *     private int cantidad;     // Mapea el campo 'cantidad'. *
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

 /**
  * 3.0 3. Crear el constructor  * Constructor vacío: Es útil cuando no tienes toda la información del producto en
  * el momento de la creación del objeto.
  *   */
    // Constructores
    public Producto() {}

    /**
     *Constructor con parámetros: Se utiliza para inicializar un objeto Producto con datos específicos.
     * El uso de this ayuda a diferenciar entre los atributos de la clase y los parámetros del constructor.
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * 4. Crear getters y setters
     * Los getters y setters permiten acceder y modificar los valores de los atributos de forma controlada.
     * Son fundamentales para seguir el principio de encapsulación.
     *
     */
    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
