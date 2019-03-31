package repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Paciente {

    public static ResultSet resultado;

    public static void Agregar_Paciente(String Nombre, String Apellido,
        float Peso, float Altura,
        int Edad, String Alergias, String Enfermedades, String TipoSangre,
        String Telefono) {

        try {

            Conexion.runner().execute(
                "{call AgregarPaciente (?,?,?,?,?,?,?,?,?)}", Nombre, Apellido,
                Peso, Altura, Edad, Alergias, Enfermedades, TipoSangre, Telefono);

            

            JOptionPane.showMessageDialog(null,
                "Datos del Paciente guardado correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Actualizar_Paciente(int ID, String Nombre,
        String Apellido, float Peso, float Altura,
        int Edad, String Alergias, String Enfermedades, String TipoSangre,
        String Telefono) {

        try {

            Conexion.runner().execute(
                "{call ModificarPaciente (?,?,?,?,?,?,?,?,?,?) }", ID, Nombre,
                Apellido, Peso, Altura, Edad, Alergias, Enfermedades,
                TipoSangre, Telefono);

            JOptionPane.showMessageDialog(null,
                "Datos del Paciente Actualizados Correctamente", "Información",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Activar_Paciente(int ID) {

        try {

            Conexion.runner().execute(
                "{call Activar_Paciente (?)}", ID);

            JOptionPane.showMessageDialog(null, "Activado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Desactivar_Paciente(int ID) {

        try {

            Conexion.runner().execute(
                "{call Desactivar_Paciente (?)}", ID);

            JOptionPane.showMessageDialog(null, "Desactivado Correctamente",
                "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                JOptionPane.ERROR_MESSAGE);

        }
    }

}
