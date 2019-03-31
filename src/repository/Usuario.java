package repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {

    public static ResultSet resultado;

    public static void Agregar_Usuario(String Nombre, String Contrasena,
        String Rol) {

        try {

            Conexion.runner().execute("{call AgregarUsuario (?,?,?)}", Nombre,
                Contrasena, Rol);

            JOptionPane.showMessageDialog(null,
                "Datos del Usuario guardado correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Usuario(int ID, String Nombre,
        String Contrasena, String Rol) {

        try {

            Conexion.runner().execute("{call ModificarUsuario (?,?,?,?) }", ID,
                Nombre,
                Contrasena, Rol);

            JOptionPane.showMessageDialog(null,
                "Datos del Usuario Actualizados Correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Usuario(int ID) {

        try {

            Conexion.runner().execute("{call Activar_Usuario (?)}", ID);

            JOptionPane.showMessageDialog(null, "Activado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Usuario(int ID) {

        try {

            Conexion.runner().execute("{call Desactivar_Usuario (?)}", ID);

            JOptionPane.showMessageDialog(null, "Desactivado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
