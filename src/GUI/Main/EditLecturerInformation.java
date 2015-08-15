/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Main;

import Lecturer_Data_Access.Lecturer_Data_Access;
import Lecturer_Domain.Lecturer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dulanjaya Tennekoon
 */
public class EditLecturerInformation extends javax.swing.JFrame {

    /**
     * Creates new form EditLecturerInformation
     */
    private Lecturer_Data_Access lecAccess;
    private Lecturer lec;
    private MainGUIObserver observer;
    private final String app_name = "NTS";
    private String defaultDestinationPath = "D:/images/";

    public EditLecturerInformation() {
        initComponents();
        startupSettings();
    }

    public EditLecturerInformation(MainGUIObserver observer, Lecturer_Data_Access lecAccess, int lecId) {
        this.lecAccess = lecAccess;
        this.observer = observer;
        initComponents();
        startupSettings();
        try {
            lec = lecAccess.getLecturerProfile(lecId);
            starupSettingsData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startupSettings() {
        this.setLocationRelativeTo(null);
    }

    public void starupSettingsData() {
        txtlecId.setText(Integer.toString(lec.getID()));
        txtlecName.setText(lec.getName());
        txtlecNIC.setText(lec.getNIC());
        txtlecAddress.setText(lec.getAddress());
        System.out.println(lec.getPicture());
        try {
            BufferedImage bi = ImageIO.read(new File(lec.getPicture()));    
            profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
        } catch (IOException e) {
            Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, e);
            BufferedImage bi;
            try {
                bi = ImageIO.read(getClass().getResource("/profilePictures/Default.png"));
                profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
            } catch (IOException ex) {
                Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IllegalArgumentException e) {
            BufferedImage bi;
            try {
                bi = ImageIO.read(getClass().getResource("/profilePictures/Default.png"));
                profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
            } catch (IOException ex) {
                Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
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
        pnlsubLecturerInfo = new javax.swing.JPanel();
        lblLecturerInfo = new javax.swing.JLabel();
        pnlLecturerInfoFields = new javax.swing.JPanel();
        lblLecturerID = new javax.swing.JLabel();
        lblLecturerName = new javax.swing.JLabel();
        lblNIC = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtlecId = new javax.swing.JTextField();
        txtlecName = new javax.swing.JTextField();
        txtlecNIC = new javax.swing.JTextField();
        txtlecAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        profPicture = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        pnlsubLecturerInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLecturerInfo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblLecturerInfo.setText("Lecturer Information");

        lblLecturerID.setText("Lecturer ID");

        lblLecturerName.setText("Lecturer Name");

        lblNIC.setText("NIC");

        jLabel1.setText("Address");

        jLabel2.setText("Subjects");

        txtlecId.setEditable(false);

        txtlecName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlecNameActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        profPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profPictureMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlLecturerInfoFieldsLayout = new javax.swing.GroupLayout(pnlLecturerInfoFields);
        pnlLecturerInfoFields.setLayout(pnlLecturerInfoFieldsLayout);
        pnlLecturerInfoFieldsLayout.setHorizontalGroup(
            pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLecturerInfoFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLecturerInfoFieldsLayout.createSequentialGroup()
                        .addComponent(lblLecturerID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(txtlecId, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLecturerInfoFieldsLayout.createSequentialGroup()
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLecturerName)
                            .addComponent(lblNIC)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtlecAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtlecNIC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtlecName)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(profPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlLecturerInfoFieldsLayout.setVerticalGroup(
            pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLecturerInfoFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLecturerInfoFieldsLayout.createSequentialGroup()
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLecturerID)
                            .addComponent(txtlecId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLecturerName)
                            .addComponent(txtlecName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNIC)
                            .addComponent(txtlecNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtlecAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLecturerInfoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlsubLecturerInfoLayout = new javax.swing.GroupLayout(pnlsubLecturerInfo);
        pnlsubLecturerInfo.setLayout(pnlsubLecturerInfoLayout);
        pnlsubLecturerInfoLayout.setHorizontalGroup(
            pnlsubLecturerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsubLecturerInfoLayout.createSequentialGroup()
                .addGroup(pnlsubLecturerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLecturerInfoFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlsubLecturerInfoLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblLecturerInfo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlsubLecturerInfoLayout.setVerticalGroup(
            pnlsubLecturerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsubLecturerInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLecturerInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLecturerInfoFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Cancel");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlsubLecturerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlsubLecturerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(62, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtlecNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlecNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlecNameActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            lec.setAccess(lecAccess);
            lec.setName(txtlecName.getText());
            lec.setNIC(txtlecNIC.getText());
            lec.setAddress(txtlecAddress.getText());
            lec.editLecturerProfile();
            observer.searchLecturerbyID();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditLecturerInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void profPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profPictureMouseClicked
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Select a Profile Picture");

        String[] suffices = ImageIO.getReaderFileSuffixes();
        for (int i = 0; i < suffices.length; i++) {
            FileFilter filter = new FileNameExtensionFilter(suffices[i] + " files", suffices[i]);
            jf.addChoosableFileFilter(filter);
        }
        InputStream instream = null;
        OutputStream outstream = null;
        int ret = jf.showDialog(null, "Choose the Profile Picture");
        if (jf.getSelectedFile() != null) {
            File source = new File(jf.getSelectedFile().getPath());
            File dest = new File(defaultDestinationPath.concat("Lec").concat(Integer.toString(lec.getID())).concat(".png"));
            System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            try {
                Files.copy(Paths.get(source.getPath()), Paths.get(dest.getPath()),StandardCopyOption.REPLACE_EXISTING);
                lec.setPicture(defaultDestinationPath.concat("Lec").concat(Integer.toString(lec.getID())).concat(".png"));
                starupSettingsData();
            } catch (IOException ex) {
                Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_profPictureMouseClicked

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
            java.util.logging.Logger.getLogger(EditLecturerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditLecturerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditLecturerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditLecturerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditLecturerInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLecturerID;
    private javax.swing.JLabel lblLecturerInfo;
    private javax.swing.JLabel lblLecturerName;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JPanel pnlLecturerInfoFields;
    private javax.swing.JPanel pnlsubLecturerInfo;
    private javax.swing.JLabel profPicture;
    private javax.swing.JTextField txtlecAddress;
    private javax.swing.JTextField txtlecId;
    private javax.swing.JTextField txtlecNIC;
    private javax.swing.JTextField txtlecName;
    // End of variables declaration//GEN-END:variables
}
