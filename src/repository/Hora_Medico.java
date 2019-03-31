/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class Hora_Medico {

    public static ResultSet resultado;

    public static void Agregar_Hora_Medico(int ID_Dia_Medico, String HoraInicio, String HoraFinal) {

        try {

            Conexion.runner().execute("{call AgregarHora_Medico (?,?,?)}",
                    ID_Dia_Medico, HoraInicio, HoraFinal);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Hora_Medico(int ID, String Titulo,
            double Cuota, double Matricula, String Ruta_Imagen) {

        try {

            Conexion.runner().execute(
                    "{call ModificarHora_Medico (?,?,?,?,?) }", ID, Titulo, Cuota,
                    Matricula, Ruta_Imagen);

            JOptionPane.showMessageDialog(null, "Datos de La Hora_Medico "
                    + "Actualizados Correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Desactivar_Hora_Medico(int ID) {

        try {

            String estado = Conexion.runner().query(
                    "Select Estado_Hora_Medico from revista where ID_Hora_Medico = ?",
                    rs -> rs.getString(0), ID);

            if ("Activo".equals(estado)) {

                Conexion.runner().execute(
                        "{call Desactivar_Hora_Medico (?)}", ID);

                JOptionPane.showMessageDialog(null,
                        "Hora_Medico Desactivada Correctamente", "Información",
                        JOptionPane.INFORMATION_MESSAGE);

            }

            if ("Inactivo".equals(estado)) {

                Conexion.runner().execute("{call Activar_Hora_Medico (?)}",
                        ID);

                JOptionPane.showMessageDialog(null,
                        "Hora_Medico Activada Correctamente", "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Hora_Medico(int ID) {

        try {

            Conexion.runner().execute("{call Activar_Hora_Medico (?)}", ID);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Hora_Medico(int ID) {

        try {

            Conexion.runner().execute("{call Desactivar_Hora_Medico (?)}", ID);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

}
