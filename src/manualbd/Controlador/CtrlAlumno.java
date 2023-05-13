package manualbd.Controlador;

import manualbd.Modelo.Conector;
import manualbd.Modelo.Alumno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import manualbd.Vista.Ventana;

/**
 * Se encarga de conectar la Clase Conector, donde se encuentra la conexión a la
 * base de datos, con la Clase Ventana que representa la interfáz gráfica
 *
 * @author Angi Casella
 */
public class CtrlAlumno implements ActionListener {

    private Alumno alum;
    private Conector conector;
    private Ventana ventana;

    /**
     * Constructor
     *
     * @param alumno datos del alum.
     * @param conector datos de conexión y métodos.
     * @param ventana datos de la ventana para la vista.
     */
    public CtrlAlumno(Alumno alumno, Conector conector, Ventana ventana) {
        this.alum = alumno;
        this.conector = conector;
        this.ventana = ventana;
        this.ventana.bGuardar.addActionListener(this);
        this.ventana.bModificar.addActionListener(this);
        this.ventana.bEliminar.addActionListener(this);
        this.ventana.bLimpiar.addActionListener(this);
        this.ventana.bBuscar.addActionListener(this);
    }

    /**
     * Método para iniciar la vista de la ventana de la interfáz gráfica.
     */
    public void iniciarVista() {
        ventana.setTitle("Alumno");
        ventana.setLocationRelativeTo(null);
        ventana.lBuscar.setVisible(false);
        refreshTabla();
    }

    /**
     * Método para asignar los eventos a los botones de la Ventana.
     *
     * @param evento evento del boton.
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == ventana.bGuardar) {
            try {
                alum.setDni(ventana.lDni.getText());
                alum.setNombre(ventana.lNombre.getText());
                alum.setApellidos(ventana.lApellidos.getText());
                alum.setEdad(Integer.parseInt(ventana.lEdad.getText()));
                if (conector.insertAlumno(alum)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    refreshTabla();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    limpiar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }
        if (evento.getSource() == ventana.bModificar) {
            alum.setDni(ventana.lDni.getText());
            alum.setNombre(ventana.lNombre.getText());
            alum.setApellidos(ventana.lApellidos.getText());
            alum.setEdad(Integer.parseInt(ventana.lEdad.getText()));
            if (conector.updateAlumno(alum)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                refreshTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        if (evento.getSource() == ventana.bEliminar) {
            alum.setDni(ventana.lDni.getText());
            if (conector.deleteAlumno(alum)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                refreshTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        if (evento.getSource() == ventana.bBuscar) {
            alum.setDni(ventana.lDni.getText());
            if (conector.searchAlumno(alum)) {
                ventana.lDni.setText(alum.getDni());
                ventana.lNombre.setText(alum.getNombre());
                ventana.lApellidos.setText(alum.getApellidos());
                ventana.lEdad.setText(String.valueOf(alum.getEdad()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
        }
        if (evento.getSource() == ventana.bLimpiar) {
            limpiar();
        }
    }

    /**
     * Método que limpia las líneas de texto.
     */
    public void limpiar() {
        ventana.lDni.setText(null);
        ventana.lNombre.setText(null);
        ventana.lApellidos.setText(null);
        ventana.lEdad.setText(null);
    }

    public void refreshTabla() {
        DefaultTableModel model = (DefaultTableModel) ventana.tablaAlumnos.getModel();
        ArrayList<Alumno> listaAlumnos = conector.listaAlumnos();
        model.setRowCount(0);
        for (Alumno alumno : listaAlumnos) {
            Object[] datos = new Object[4];
            datos[0] = (alumno.getDni());
            datos[1] = (alumno.getNombre());
            datos[2] = (alumno.getApellidos());
            datos[3] = (alumno.getEdad());

            //añado el modelo a la tabla
            model.addRow(datos);
        }

    }
}
