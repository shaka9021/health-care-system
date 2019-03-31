/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Consulta {

    public static ResultSet resultado;

    public static void Agregar_Consulta(int ID_Cita, String Consulta,
        String Diagnostico, String Receta) {

        try {

            Conexion.runner().execute("{call AgregarConsulta (?,?,?,?)}",
                ID_Cita,
                Consulta, Diagnostico, Receta);

            JOptionPane.showMessageDialog(null,
                "Datos de la Consulta guardado correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Consulta(int ID, String Consulta,
        String Diagnostico, String Receta) {

        try {

            Conexion.runner().execute(
                "{call ModificarConsulta (?,?,?,?) }", ID, Consulta, Diagnostico,
                Receta);

            JOptionPane.showMessageDialog(null,
                "Datos de La Consulta Actualizados Correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Consulta(int ID) {

        try {

            Conexion.runner().execute(
                "{call Activar_Consulta (?)}", ID);

            JOptionPane.showMessageDialog(null, "Activada Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Consulta(int ID) {

        try {

            Conexion.runner().execute(
                "{call Desactivar_Consulta (?)}", ID);

            JOptionPane.showMessageDialog(null, "Desactivada Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
