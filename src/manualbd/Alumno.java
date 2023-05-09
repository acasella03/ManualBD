package manualbd;

/**
 * Clase que define a un alumno
 *
 * @author Angi Casella
 */
public class Alumno {

    private String dni, nombre, apellidos;
    private int edad;

    public Alumno(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Para que el alumno se guarde automáticamente.
     */
    public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveAlumno(this);
        con.close();
    }
}
