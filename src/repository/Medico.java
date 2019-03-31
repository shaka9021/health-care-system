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

/**
 *
 * @author UNI
 */
public class Medico {

    public static ResultSet resultado;

    public static void Agregar_Medico(String Nombre, String Apellido,
            int ID_Especialidad) {

        try {

            Conexion.runner().execute("{call AgregarMedico (?,?,?)}",
                    Nombre, Apellido, ID_Especialidad);

            JOptionPane.showMessageDialog(null,
                    "Datos del Medico guardado correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Medico(int ID, String Nombre, String Apellido, int ID_Especialidad) {

        try {

            Conexion.runner().execute("{call ModificarMedico (?,?,?,?) }",
                    ID, Nombre, Apellido, ID_Especialidad);
            JOptionPane.showMessageDialog(null, "Datos del Medico "
                    + "Actualizados Correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Usuario_Medico(int ID_M, int ID_U, String Usuario) {

        try {

            Conexion.runner().execute("{call UsuarioMedico (?,?)}", 
                    ID_M, ID_U);
            JOptionPane.showMessageDialog(null, 
                "Medico agregado con Nombre Usuario: " + Usuario,
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Medico(int ID) {

        try {

            Conexion.runner().execute("{call Desactivar_Medico (?)}", ID);
            JOptionPane.showMessageDialog(null, "Desactivado Correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Medico(int ID) {

        try {

            Conexion.runner().execute("{call Activar_Medico (?)}", ID);
            JOptionPane.showMessageDialog(null, "Activado Correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
