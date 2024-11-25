/**
 * 1. Crear la clase Main
 * Define la clase Main con un método main, que es el punto de inicio del programa.
 */

public class Main {
    public static void main(String[] args) {
/**
 * 2. Instanciar ProductoDAO
 *    Dentro del método main, crea una instancia de ProductoDAO para usar sus métodos. Este objeto permitirá
 *    interactuar con la base de datos.
 *    3. Manejar excepciones
 *    Como los métodos del DAO lanzan excepciones de tipo SQLException, envuelve las operaciones CRUD en un bloque
 *    try-catch para manejar posibles errores de conexión o consultas.
      4.Operaciones CRUD:
      Agrega llamadas a los métodos del DAO para realizar operaciones sobre la base de datos.
       a) Crear un producto (Create)  Usa el método insertarProducto para agregar un nuevo producto.  */
        ProductoDAO productoDAO = new ProductoDAO();
        // Crear un producto
        Producto nuevoProducto = new Producto("tablet", 800000, 5);
        productoDAO.insertarProducto(nuevoProducto);
        // Leer productos
        System.out.println("Lista de productos:");
        for (Producto p : productoDAO.listarProductos()) {
            System.out.println(p.getId() + " - " + p.getNombre() + " - $" + p.getPrecio() + " - Cantidad: " + p.getCantidad());
        }

        // Actualizar un producto
        nuevoProducto.setNombre("Laptop Actualizada");
        nuevoProducto.setPrecio(1150.75);
        productoDAO.actualizarProducto(nuevoProducto);

        // Eliminar un producto
        productoDAO.eliminarProducto(1);


    }
}