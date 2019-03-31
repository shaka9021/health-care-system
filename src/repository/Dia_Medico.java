package repository;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dia_Medico {

    public static void Agregar_Dia_Medico(int ID_Medico, String Dia) {

        try {

            Conexion.runner().execute(
                "{call AgregarDia_Medico (?,?)}", ID_Medico, Dia);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Dia_Medico(int ID, String Titulo,
        double Cuota, double Matricula, String Ruta_Imagen) {

        try {

            Conexion.runner().execute(
                "{call ModificarDia_Medico (?,?,?,?,?)}", ID, Titulo, Cuota,
                Matricula, Ruta_Imagen);

            JOptionPane.showMessageDialog(null,
                "Datos de La Dia_Medico Actualizados Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Desactivar_Dia_Medico(int ID) {

        try {

            String estado = Conexion.runner().query(
                "Select Estado_Dia_Medico from revista where ID_Dia_Medico = ?",
                rs -> rs.getString(1), ID);

            if ("Activo".equals(estado)) {

                Conexion.runner().execute(
                    "{call Desactivar_Dia_Medico (?)}", ID);

                JOptionPane.showMessageDialog(null,
                    "Dia_Medico Desactivada Correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            }

            if ("Inactivo".equals(estado)) {

                Conexion.runner().execute(
                    "{call Activar_Dia_Medico (?)}", ID);

                JOptionPane.showMessageDialog(null,
                    "Dia_Medico Activada Correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Dia_Medico(int ID) {

        try {

            Conexion.runner().execute(
                "{call Activar_Dia_Medico (?)}", ID);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Dia_Medico(int ID) {

        try {

            Conexion.runner().execute(
                "{call Desactivar_Dia_Medico (?)}", ID);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
