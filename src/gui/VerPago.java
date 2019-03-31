/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import repository.Conexion;
import repository.Pago;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UNI
 */
public class VerPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form AgregarDoctor
     */
    public VerPago() {
        initComponents();
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ver Pago");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1439253074_power_off.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1435355601_sign-error.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel1.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 705, 510);
    }// </editor-fold>//GEN-END:initComponents

    
    public void ActDes(){
        
           
int Fila = jTable1.getSelectedRow();
int Col = 5;

     //   System.out.println("Fila "+Fila);

if(Fila >= 0){
  
    int ID = Integer.parseInt(model.getValueAt(Fila, 0).toString());
    String Estado = model.getValueAt(Fila, Col).toString();
    
    if(Estado.equalsIgnoreCase("Activo")){
        Pago.Cancelar_Pago(ID); //Des  
    }
    else{
        JOptionPane.showMessageDialog(this, "Ya ha cancelado este pago anteriormente", 
            "Cancelado", JOptionPane.ERROR_MESSAGE);   
    }

    CargarDatos();
    
}
else{
    JOptionPane.showMessageDialog(this, "Debe seleccionar el pago a cancelar", 
            "Seleccione", JOptionPane.ERROR_MESSAGE);  
} 
    }
  
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
ActDes();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    ResultSet resultado;
    
    public void CargarDatos(){
                model.setRowCount(0);
         
        String[] Header = {"No.", "Fecha", "Cliente", "Usuario", "Total", "Estado"};
        model.setColumnIdentifiers(Header);

        String[] Datos = new String[6];

        try {

            resultado = Conexion.consulta("Select * from PagoV");

            while (resultado.next()) {
                Datos[0] = String.valueOf(resultado.getInt(1));
                SimpleDateFormat SDF = new SimpleDateFormat("dd-MMM-yyyy");
                Date Fecha = resultado.getDate(2);
                Datos[1] = SDF.format(Fecha);
                String Cliente = resultado.getString(3).trim() + " " + resultado.getString(4).trim();
                Datos[2] = Cliente;
                Datos[3] = resultado.getString(5);
                Datos[4] = String.valueOf(resultado.getDouble(6));
                boolean Estado = resultado.getBoolean(7);
                String Estate = "Cancelado";
                if (Estado) {
                    Estate = "Activo";
                }
                Datos[5] = Estate;

                model.addRow(Datos);
            }

        } catch (SQLException ex) {

        }

        jTable1.setModel(model);
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

CargarDatos();

// TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

int Fila = jTable1.getSelectedRow();

if(Fila >= 0){
  
    int ID_Pago = Integer.parseInt(model.getValueAt(Fila, 0).toString());
    
    if(evt.getClickCount()==2 && evt.getButton()==MouseEvent.BUTTON1){
        
        VerDetallePago VP = new VerDetallePago(null, true);
        VP.CargarDatos(ID_Pago);
        VP.setVisible(true);
        
    }
    
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    public void Buscar(){
        String Buscar = txtBuscar.getText();
        
               model.setRowCount(0);
         
        String[] Header = {"No.", "Fecha", "Cliente", "Usuario", "Total", "Estado"};
        model.setColumnIdentifiers(Header);

        String[] Datos = new String[6];

        try {

            resultado = Conexion.consulta("Select * from PagoV where Nombres like '%"+Buscar+"%' "
                    + "or Apellidos like '%"+Buscar+"%'");

            while (resultado.next()) {
                Datos[0] = String.valueOf(resultado.getInt(1));
                SimpleDateFormat SDF = new SimpleDateFormat("dd-MMM-yyyy");
                Date Fecha = resultado.getDate(2);
                Datos[1] = SDF.format(Fecha);
                String Cliente = resultado.getString(3).trim() + " " + resultado.getString(4).trim();
                Datos[2] = Cliente;
                Datos[3] = resultado.getString(5);
                Datos[4] = String.valueOf(resultado.getDouble(6));
                boolean Estado = resultado.getBoolean(7);
                String Estate = "Cancelado";
                if (Estado) {
                    Estate = "Activo";
                }
                Datos[5] = Estate;

                model.addRow(Datos);
            }

        } catch (SQLException ex) {

        }

        jTable1.setModel(model);
        
    }
    
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
Buscar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {

            return false;
        }

    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
