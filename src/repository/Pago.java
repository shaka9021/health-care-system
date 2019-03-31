package repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pago {

    public static ResultSet resultado;

    public static void Agregar_Pago(int ID_Paciente, int ID_Usuario) {

        try {

            Conexion.runner().execute("{call AgregarPago (?,?)}", ID_Paciente,
                ID_Paciente);

            JOptionPane.showMessageDialog(null,
                "Datos del Pago guardado correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Agregar_DetellePago(int ID_Pago, int ID_Servicio,
        int Cantidad) {

        try {

            Conexion.runner().execute("{call AgregarDetallePago (?,?,?)}",
                ID_Pago, ID_Servicio, Cantidad);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Pago(int ID, String Titulo,
        double Cuota, double Matricula, String Ruta_Imagen) {

        try {

            Conexion.runner().execute("{call ModificarPago (?,?,?,?,?) }", ID,
                Titulo, Cuota, Matricula, Ruta_Imagen);

            JOptionPane.showMessageDialog(null,
                "Datos de La Pago Actualizados Correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Cancelar_Pago(int ID) {

        try {

            Conexion.runner().execute("{call Cancelar_DPago (?)}", ID);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }

        try {

            Conexion.runner().execute("{call Cancelar_Pago (?)}", ID);

            JOptionPane.showMessageDialog(null, "Cancelado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
