package manualbd.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que realiza la conexión y consultas de la base de datos
 *
 * @author Angi Casella
 */
public class Conector {

    /**
     * Ruta de ubicación de la base de datos
     */
    String url = "file:///C:/Users/Angita/Documents/NetBeansProjects/ManualBD/base_de_datos/MiBaseDeDatos.db";
    Connection connect = null;
    ResultSet result = null;

    /**
     * Realiza la conexión a la base de tados
     */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * @param alumno a guardar.
     * @return T cuando conecta a la base de datos y realiza la inserción en la
     * tabla, sino retorna F
     */
    public boolean insertAlumno(Alumno alumno) {
        connect();
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumno (dni, nombre, apellidos, edad) values (?,?,?,?)");
            st.setString(1, alumno.getDni().toUpperCase());
            st.setString(2, alumno.getNombre().toUpperCase());
            st.setString(3, alumno.getApellidos().toUpperCase());
            st.setInt(4, alumno.getEdad());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            close();
        }

    }

    /**
     * Modifica un alumno en la base de datos.
     *
     * @param alumno a modificar.
     * @return T cuando conecta a la base de datos y realiza la actualización en
     * la tabla, sino retorna F
     */
    public boolean updateAlumno(Alumno alumno) {
        connect();
        try {
            PreparedStatement st = connect.prepareStatement("update alumno set dni=?, nombre=?, apellidos=?, edad=? where dni=?");
            st.setString(1, alumno.getDni().toUpperCase());
            st.setString(2, alumno.getNombre().toUpperCase());
            st.setString(3, alumno.getApellidos().toUpperCase());
            st.setInt(4, alumno.getEdad());
            st.setString(5, alumno.getDni());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            close();
        }

    }

    /**
     * Borra un alumno en la basse de datos.
     *
     * @param alumno a eliminar.
     * @return T cuando conecta a la base de datos y realiza el borrado en la
     * tabla, sino retorna F
     */
    public boolean deleteAlumno(Alumno alumno) {
        connect();
        try {
            PreparedStatement st = connect.prepareStatement("delete from alumno where dni=?");
            st.setString(1, alumno.getDni());
            st.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            close();
        }
    }

    /**
     * Busca un alumno en la base de datos.
     *
     * @param alumno a buscar.
     * @return T cuando conecta a la base de datos y realiza la búsqueda en la
     * tabla, sino retorna F
     */
    public boolean searchAlumno(Alumno alumno) {
        connect();
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumno where dni=?");
            st.setString(1, alumno.getDni().toUpperCase());
            result = st.executeQuery();
            if (result.next()) {
                alumno.setDni(result.getString("DNI"));
                alumno.setNombre(result.getString("Nombre"));
                alumno.setApellidos(result.getString("Apellidos"));
                alumno.setEdad(Integer.parseInt(result.getString("edad")));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            close();
        }
    }

    /**
     * Realiza consultas de una tabla
     *
     * @return la lista con todos los alumnos
     */
    public ArrayList<Alumno> listaAlumnos() {
        connect();
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumno");
            result = st.executeQuery();
            while (result.next()) {
                Alumno alumno = new Alumno();
                alumno.setDni(result.getString("dni"));
                alumno.setNombre(result.getString("nombre"));
                alumno.setApellidos(result.getString("apellidos"));
                alumno.setEdad(result.getInt("edad"));

                listaAlumnos.add(alumno);

                /*System.out.print("DNI: ");
                System.out.println(result.getString("dni"));

                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));

                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellidos"));

                System.out.print("Edad: ");
                System.out.println(result.getInt("edad"));

                System.out.println("=======================");*/

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally{
            close();
        }
        return listaAlumnos;
    }
}
