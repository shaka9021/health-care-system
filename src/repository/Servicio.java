package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Servicio {

    public static ResultSet resultado;

    public static void Agregar_Servicio(String Nombre, String Descripcion,
        double Precio) {

        try {

            Conexion.runner().execute("{call AgregarServicio (?,?,?)}", Nombre,
                Descripcion, Precio);

            JOptionPane.showMessageDialog(null,
                "Datos del Servicio guardado correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Servicio(int ID, String Nombre,
        String Descripcion, double Precio) {

        try {

            Conexion.runner().execute("{call ModificarServicio (?,?,?,?) }", ID,
                Nombre, Descripcion, Precio);

            JOptionPane.showMessageDialog(null,
                "Datos del Servicio Actualizados Correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Servicio(int ID) {

        try {

            Conexion.runner().execute("{call Activar_Servicio (?)}", ID);

            JOptionPane.showMessageDialog(null, "Activado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Servicio(int ID) {

        try {

            Conexion.runner().execute("{call Desactivar_Servicio (?)}", ID);

            JOptionPane.showMessageDialog(null, "Desactivado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
