package manualbd.Controlador;

import manualbd.Modelo.Conector;
import manualbd.Modelo.Alumno;
import manualbd.Vista.Ventana;

/**
 * Clase de ejecución
 *
 * @author Angi Casella
 */
public class ManualBD {

    public static void main(String[] args) {
        Alumno mod = new Alumno();
        Conector modC = new Conector();
        Ventana ventana = new Ventana();
        CtrlAlumno ctrl = new CtrlAlumno(mod, modC, ventana);

        ctrl.iniciarVista();
        ventana.setVisible(true);

    }

}
