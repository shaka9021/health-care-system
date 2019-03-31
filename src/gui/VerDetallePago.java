/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import repository.Conexion;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 *
 * @author UNI
 */
public class VerDetallePago extends javax.swing.JDialog {

    /**
     * Creates new form VerHorario
     */
    public VerDetallePago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Detalles de Pago");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addGap(39, 39, 39)))
        );

        setSize(new java.awt.Dimension(711, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void CargarDatos(int ID_Pago) {

        String[] Header = {"Codigo", "No.", "Servicio", "Precio", "Cantidad",
            "Total", "Estado"};
        model.setColumnIdentifiers(Header);
        this.jTable1.setModel(model);

        try {

            Conexion.runner().query(
                "Select * from Detalle_PagoV "
                + "Where ID_Pago = ?",
                rs -> {

                List<String[]> r = new ArrayList<>();

                while (rs.next()) {

                    String[] Datos = new String[7];

                    Datos[0] = String.valueOf(rs.getInt(1));
                    Datos[1] = String.valueOf(rs.getInt(2));
                    Datos[2] = rs.getString(3);
                    Datos[3] = String.valueOf(rs.getDouble(4));
                    Datos[4] = String.valueOf(rs.getInt(5));
                    Datos[5] = String.valueOf(rs.getDouble(6));
                    boolean Estado = rs.getBoolean(7);
                    String Estate = "Cancelado";
                    if (Estado) {
                        Estate = "Activo";
                    }
                    Datos[6] = Estate;

                    r.add(Datos);
                }

                return r;
            }, ID_Pago).stream().forEach(model::addRow);

        } catch (SQLException ex) {

        }

        jTable1.setModel(model);

    }

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).
                log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).
                log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).
                log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).
                log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerDetallePago dialog = new VerDetallePago(
                    new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
