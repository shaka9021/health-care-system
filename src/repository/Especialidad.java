/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class Especialidad {

    public static void Agregar_Especialidad(String Nombre, String Descripcion) {

        try {

            Conexion.runner().execute("{call AgregarEspecialidad (?,?)}",
                    Nombre, Descripcion);
            JOptionPane.showMessageDialog(null, "Datos de la Especialidad "
                    + "guardado correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Especialidad(int ID, String Nombre,
            String Descripcion) {

        try {

            Conexion.runner().execute(
                    "{call ModificarEspecialidad (?,?,?) }",
                    ID, Nombre, Descripcion);

            JOptionPane.showMessageDialog(null, "Datos de La Especialidad "
                    + "Actualizados Correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Especialidad(int ID) {

        try {

            Conexion.runner().execute("{call Activar_Especialidad (?)}", ID);
            JOptionPane.showMessageDialog(null, "Activado Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Especialidad(int ID) {

        try {

            Conexion.runner().execute("{call Desactivar_Especialidad (?)}",
                    ID);
            JOptionPane.showMessageDialog(null, "Desactivado Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

}
