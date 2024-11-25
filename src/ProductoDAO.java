/**
 * El DAO (Data Access Object) es un patrón de diseño que se utiliza para separar la lógica de acceso a la base de
 * datos del resto de la aplicación. En este caso, ProductoDAO será la clase encargada de interactuar con la base de
 * datos para realizar operaciones CRUD relacionadas con la clase Producto.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private final Connection connection;

    public ProductoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Create
    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre, precio, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Update
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getCantidad());
            stmt.setInt(4, producto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM producto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
