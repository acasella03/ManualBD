package manualbd;

import com.sun.jdi.connect.spi.Connection;

/**
 * Clase que realiza la conexión y consultas de la base de datos
 *
 * @author Angi Casella
 */
public class Conector {

    /**
     * Ruta de ubicación de la base de datos
     */
    String url = "file:///home/dam1/NetBeansProjects/ManualBD/base_de_datos/MiBaseDeDatos.db";
    Connection connect;

    /**
     * Realiza la conexión a la base de tados
     */
    public void connect() {
        try {
            
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    /**
     * Realiza la desconexión de la base de datos
     */
    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Guardar un alumno en la base de datos.
     * @param alumno a guardar.
     */
    public void saveAlumno(Alumno alumno){
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (dni, nombre, apellidos, edad) values (?,?,?,?)");
            st.setString(1, alumno.getDni());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getApellidos());
            st.setInt(4, alumno.getEdad());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
