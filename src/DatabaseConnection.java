//Importar las bibliotecas necesarias.
/**
 * Connection: Representa una conexión a la base de datos. Es el objeto que usaremos para ejecutar consultas SQL.
 * DriverManager: Es la clase que gestiona los controladores JDBC y nos permite obtener conexiones a bases de datos.
 * SQLException: Es la excepción que se lanza cuando ocurre un error relacionado con la base de datos.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    /**
     * 2.Declarar los datos de conexión:
     * jdbc:mysql://: Protocolo para conectarse a MySQL.
     * localhost: Indica que la base de datos está en la máquina local. se Cambia esto por la dirección IP o nombre de
     * dominio si está en un servidor remoto.
     * 3307: El puerto predeterminado para MySQL.
     * /tienda: El nombre del esquema (base de datos).
     * USER: El usuario con permisos para acceder a la base de datos.
     * PASSWORD: La contraseña asociada a ese usuario.
     * - private: Control de acceso: Indica que la constante solo es accesible dentro de la misma clase donde fue declarada.
     *   Esto significa que no podrá ser utilizada directamente por otras clases, a menos que la expongas a través de un
     *   método public.
     * - static: Pertenencia a la clase: La constante pertenece a la clase y no a las instancias (objetos) de esa clase.
     *   Esto significa que:      * No necesitas crear un objeto para usar la constante.      * Todas las instancias de la
     *   clase comparten el mismo valor.      * Es común en variables que no dependen del estado de un objeto.
     * - final: Inmutabilidad: El valor no puede cambiar después de ser asignado.      * Esto significa que:
     *   Si es un tipo primitivo (por ejemplo, int), no puedes cambiar su valor.
     *   Si es un objeto (por ejemplo, String o List), no puedes asignar un nuevo objeto, pero puedes modificar su
     *   contenido interno si no es inmutable.
     *
     */
    private static final String URL = "jdbc:mysql://localhost:3307/tienda";
    private static final String USER = "root"; // usuario
    private static final String PASSWORD = "iron"; // contraseña

    /**
     *3. Crear el método getConnection:
     * - Declarar una variable para la conexión: Connection connection = null;Se inicializa en null para asegurarse de
     *   que se tenga un valor predeterminado en caso de que falle la conexión.
     * - Intentar establecer la conexión:connection = DriverManager.getConnection(URL, USER, PASSWORD);
     *   DriverManager.getConnection(): Establece una conexión con la base de datos usando la URL, el usuario y la
     *   contraseña proporcionados.      * Si la conexión es exitosa, devuelve un objeto Connection que se utiliza para
     *   interactuar con la base de datos.
     * -  Manejar excepciones: catch (SQLException e) {      *     e.printStackTrace();      * } , Si ocurre algún
     *    problema (por ejemplo, las credenciales son incorrectas o la base de datos no está disponible), se lanza una
     *    excepción SQLException. Con e.printStackTrace(), se imprime el error en la consola para depurar.
     * -  return connection; * Devuelve el objeto Connection para que pueda ser usado por otras partes del programa.
     */

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
