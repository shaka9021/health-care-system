/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class Cita {

    public static ResultSet resultado;

    public static void Agregar_Cita(Date Fecha, String Hora, int ID_Medico, 
            int ID_Paciente, String Dia_Semana,
            int Semana_Cita) {

        String Estado = "Pendiente";

        long date = Fecha.getTime();
        java.sql.Date FechaC = new java.sql.Date(date);

        try {

            Conexion.runner().execute("{call AgregarCita (?,?,?,?,?,?,?)}",
                    FechaC,Hora,ID_Medico,ID_Paciente,Estado,Dia_Semana,
                    Semana_Cita);

            JOptionPane.showMessageDialog(null, 
                    "Datos de la Cita guardado correctamente", "Información", 
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
            
        }

    }

    public static void Actualizar_Cita(int ID, String Titulo,
            double Cuota, double Matricula, String Ruta_Imagen) {

        try {

            Conexion.runner().execute("{call ModificarCita (?,?,?,?,?) }",ID,
            Titulo,Cuota,Matricula,Ruta_Imagen);

            JOptionPane.showMessageDialog(null, 
                    "Datos de La Cita Actualizados Correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Cita_Atendida(int ID) {

        try {

            Conexion.runner().execute("{call CitaAtendida (?)}",ID);
            
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void Cancelar_Cita(int ID) {

        try {

            Conexion.runner().execute("{call Cancelar_Cita (?)}",ID);

            JOptionPane.showMessageDialog(null, "Cancelada Correctamente", 
                    "Información", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

}
