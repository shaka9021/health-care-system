/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import repository.Conexion;
import repository.Medico;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class ModificarMedico extends javax.swing.JDialog {

    /**
     * Creates new form AgregarDoctor
     * @param parent
     * @param modal
     */
    public ModificarMedico (java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Modificar Medico");

        jPanel2.setLayout(new java.awt.GridLayout(4, 2, 0, 12));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel7.setText("Nombres");
        jPanel2.add(jLabel7);

        txtNombre.setDoubleBuffered(true);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre);

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel10.setText("Apellidos");
        jPanel2.add(jLabel10);

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido);

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jLabel8.setText("Especialidad");
        jPanel2.add(jLabel8);

        cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        jPanel2.add(cmbEspecialidad);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1435355589_floppy.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1435357592_Timetable.png"))); // NOI18N
        jButton2.setText("Modificar Horario");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 684, 349);
    }// </editor-fold>//GEN-END:initComponents

    int IDD;
    
     public void CargarDatos(int ID){
        
        CargarEspecialidad();
         
        String Nombre="";
        String Apellido = "";
        String Especialidad="";
        
        try{
            
            resultado = Conexion.consulta("Select ID_Medico, Nombres, Apellidos, Nombre "
                    + " from MedicoV Where ID_Medico = "+ID);
            
            while(resultado.next()){
             IDD = resultado.getInt(1);
             Nombre = resultado.getString(2);
             Apellido = resultado.getString(3);
             Especialidad = resultado.getString(4);
                
            }
            
        }catch(SQLException ex){}
        
        txtNombre.setText(Nombre);
        txtApellido.setText(Apellido);
        
        cmbEspecialidad.setSelectedItem(Especialidad);
        
      
        
    }
    
    public void Guardar(){
        String Nombre = txtNombre.getText().trim();
        String Apellido = txtApellido.getText().trim();
        int cmbEsp = cmbEspecialidad.getSelectedIndex();
        int ID_Especialidad = ID_Esp[cmbEsp];
     /*   String HoraInicio = (String) cmbDesde.getSelectedItem();
        String HoraFinal = (String) cmbHasta.getSelectedItem();
        boolean L = ckL.isSelected();
        boolean M = ckM.isSelected();
        boolean X = ckX.isSelected();
        boolean J = ckJ.isSelected();
        boolean V = ckV.isSelected();
        boolean S = ckS.isSelected();
        boolean D = ckD.isSelected();
        
        int HRi = cmbDesde.getSelectedIndex();
        int HRs = cmbHasta.getSelectedIndex();
        
        if(HRi>HRs){
                    JOptionPane.showMessageDialog
        (this, "La hora de salida no puede ser menor que la de entrada, y la hora de entrada no puede ser mayor que"
                + " la de salida",
                "Seleccione correctamente",JOptionPane.ERROR_MESSAGE);
                    return;
        }
        
             */
        
        if("".equals(Nombre)||"".equals(Apellido)||cmbEsp==0)
                //||"<Seleccione>".equals(HoraFinal)
           //     ||"<Seleccione>".equals(HoraInicio))
        {
                    JOptionPane.showMessageDialog
        (this, "Complete todos los campos y seleccione correctamente",
                "Complete",JOptionPane.ERROR_MESSAGE);
        }
        else{
          
            
      Medico.Actualizar_Medico(IDD, Nombre, Apellido, ID_Especialidad);
            
//            Horario H = new Horario(null, true);
//            H.setAM(this);
//            H.setNombre(Nombre);
//            H.setApellido(Apellido);
//            H.setID_Especialidad(ID_Especialidad);
//            H.setVisible(true);
            
            Limpiar();// TODO add your handling code here:

            }
        
    }
    
    public void ModificarHorario(){
        
        ModificarHorario MH = new ModificarHorario(null, true);
        MH.setID(IDD);
        MH.CargarDatos(IDD);
        MH.setVisible(true);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
ModificarHorario(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    ResultSet resultado;
    int ID_Esp [];
    
public void CargarEspecialidad(){
            
     int ID_Especialidad = 0;
     
      try{
         
     resultado = Conexion.consulta("Select Max(ID_Especialidad) from Especialidad");
         
     while(resultado.next()){
         ID_Especialidad = resultado.getInt(1);
     }
     }catch(SQLException ex){
         
     }
        
      
      ID_Especialidad++;
   
      ID_Esp = new int[ID_Especialidad];


       
      ID_Esp [0] = 0; 
      
      int i = 1;
      
      try{
         
     resultado = Conexion.consulta("Select ID_Especialidad, Nombre from Especialidad Where Estado = 1");
         
     while(resultado.next()){
         ID_Esp [i] = resultado.getInt(1);
         cmbEspecialidad.addItem(resultado.getString(2).trim());
         i++;
     }
     }catch(SQLException ex){
         
     }
       
        
}

private VerMedico VM;

    public void setVM(VerMedico VM) {
        this.VM = VM;
    }


    
    public void Limpiar(){
        VM.CargarDatos();
        dispose();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Guardar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Limpiar();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
char a = evt.getKeyChar();

if(!Character.isLetter(a)&&!Character.isISOControl(a)&&a!=' '){
    evt.consume();
    Toolkit.getDefaultToolkit().beep();
}        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
char a = evt.getKeyChar();

if(!Character.isLetter(a)&&!Character.isISOControl(a)&&a!=' '){
    evt.consume();
    Toolkit.getDefaultToolkit().beep();
}        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoKeyTyped

                                         


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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDetallePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarMedico dialog = new ModificarMedico(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
