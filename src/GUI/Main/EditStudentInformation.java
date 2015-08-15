/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Main;

import Student_Data_Access.Student_Data_Access;
import Student_Domain.Student;
import com.sun.corba.se.spi.copyobject.CopyobjectDefaults;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author Dulanjaya Tennekoon
 */
public class EditStudentInformation extends javax.swing.JFrame {

    /**
     * Creates new form EditStudentInfromation
     */
    private String app_name = "NTS";
    private Student_Data_Access stuAccess;
    private Student stu;
    private MainGUIObserver GUIObserver;
    private String defaultDestinationPath = "D:/images/";

    public EditStudentInformation() throws HeadlessException {
        initComponents();
        startupSettings();
    }

    public EditStudentInformation(MainGUIObserver GUIObserver, Student_Data_Access stuAccess, String stuId) {
        initComponents();
        startupSettings();
        this.GUIObserver = GUIObserver;
        this.stuAccess = stuAccess;
        try {
            stu = stuAccess.getProfile(Integer.parseInt(stuId));
            stu.setAccess(stuAccess);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Student ID", app_name, JOptionPane.WARNING_MESSAGE);
        }
        startUpSettingData(stuAccess, stuId);
    }

    public void startUpSettingData(Student_Data_Access stuAccess, String stuId) {
        Student stu;
        try {
            stu = stuAccess.getProfile(Integer.parseInt(stuId));
            stu.setAccess(stuAccess);
            txtStuID.setText(Integer.toString(stu.getID()));
            txtStuName.setText(stu.getName());
            dpDOB.setDate(stu.getDOB());
            txtBatch.setText(Integer.toString(stu.getBatch()));
            txtAddress.setText(stu.getAddress());
            txtIDno.setText(stu.getNIC());
            txtPhone.setText(Integer.toString(stu.getPhone()));
            dpDOReg.setDate(stu.getDate());
            txtGuardName1.setText(stu.getGuadian1Name());
            txtGuardAddress1.setText(stu.getGuadian1Address());
            txtGuardPhone1.setText(Integer.toString(stu.getGuadian1Telephone()));
            txtGuardName2.setText(stu.getGuadian2Name());
            txtGuardAddress2.setText(stu.getGuadian2Address());
            txtGuardPhone2.setText(Integer.toString(stu.getGuadian2Telephone()));
            chkHostel.setSelected(stu.isIsHostel());
            System.out.println(stu.getPicture());
            try {
                BufferedImage bi = ImageIO.read(new File(stu.getPicture()));
                profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
            } catch (IOException e) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
                BufferedImage bi = ImageIO.read(getClass().getResource("/profilePictures/Default.png"));
                profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
            } catch (IllegalArgumentException e) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
                BufferedImage bi = ImageIO.read(getClass().getResource("/profilePictures/Default.png"));
                profPicture.setIcon(new ImageIcon(bi.getScaledInstance(142, 162, 10)));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Enter a Valid Index Please!", app_name, JOptionPane.WARNING_MESSAGE);
        }
    }

    public void startupSettings() {
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlStuPersonalInfo = new javax.swing.JPanel();
        lblStuInfoHeading = new javax.swing.JLabel();
        lblStuID = new javax.swing.JLabel();
        txtStuID = new javax.swing.JTextField();
        lblStuName = new javax.swing.JLabel();
        txtStuName = new javax.swing.JTextField();
        lblBatch = new javax.swing.JLabel();
        txtBatch = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        jspAddress = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblIDNo = new javax.swing.JLabel();
        txtIDno = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblDOB = new javax.swing.JLabel();
        lblDOReg = new javax.swing.JLabel();
        lblGuardName1 = new javax.swing.JLabel();
        txtGuardName1 = new javax.swing.JTextField();
        lblGuardPhone1 = new javax.swing.JLabel();
        txtGuardPhone1 = new javax.swing.JTextField();
        lblHostel = new javax.swing.JLabel();
        chkHostel = new javax.swing.JCheckBox();
        lblGuardAddress1 = new javax.swing.JLabel();
        lblGuardAddress2 = new javax.swing.JLabel();
        lblGuardPhone2 = new javax.swing.JLabel();
        txtGuardPhone2 = new javax.swing.JTextField();
        txtGuardName2 = new javax.swing.JTextField();
        lblGuardName2 = new javax.swing.JLabel();
        jspAddress1 = new javax.swing.JScrollPane();
        txtGuardAddress1 = new javax.swing.JTextArea();
        jspAddress2 = new javax.swing.JScrollPane();
        txtGuardAddress2 = new javax.swing.JTextArea();
        dpDOB = new org.jdesktop.swingx.JXDatePicker();
        dpDOReg = new org.jdesktop.swingx.JXDatePicker();
        profPicture = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(405, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblStuInfoHeading.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblStuInfoHeading.setText("Student Information");

        lblStuID.setText("Student ID");

        txtStuID.setEditable(false);

        lblStuName.setText("Student Name");

        lblBatch.setText("Batch");

        lblAddress.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jspAddress.setViewportView(txtAddress);

        lblIDNo.setText("NIC");

        lblPhone.setText("Phone Number");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        lblDOB.setText("Date of Birth");

        lblDOReg.setText("Registration Date");

        lblGuardName1.setText("Guardian1's Name");

        txtGuardName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardName1ActionPerformed(evt);
            }
        });

        lblGuardPhone1.setText("Guardian1's Phone");

        lblHostel.setText("Hostel Student");

        chkHostel.setText("hostel Student");
        chkHostel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHostelActionPerformed(evt);
            }
        });

        lblGuardAddress1.setText("Guardian1's Address");

        lblGuardAddress2.setText("Guardian2's Address");

        lblGuardPhone2.setText("Guardian2's Phone");

        txtGuardName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuardName2ActionPerformed(evt);
            }
        });

        lblGuardName2.setText("Guardian2's Name");

        txtGuardAddress1.setColumns(20);
        txtGuardAddress1.setRows(5);
        jspAddress1.setViewportView(txtGuardAddress1);

        txtGuardAddress2.setColumns(20);
        txtGuardAddress2.setRows(5);
        jspAddress2.setViewportView(txtGuardAddress2);

        profPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        profPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profPictureMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlStuPersonalInfoLayout = new javax.swing.GroupLayout(pnlStuPersonalInfo);
        pnlStuPersonalInfo.setLayout(pnlStuPersonalInfoLayout);
        pnlStuPersonalInfoLayout.setHorizontalGroup(
            pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDOB)
                    .addComponent(lblBatch)
                    .addComponent(lblStuName)
                    .addComponent(lblStuID)
                    .addComponent(lblIDNo)
                    .addComponent(lblDOReg)
                    .addComponent(lblGuardName1)
                    .addComponent(lblGuardPhone1)
                    .addComponent(lblGuardName2)
                    .addComponent(lblGuardPhone2)
                    .addComponent(lblGuardAddress2)
                    .addComponent(lblHostel)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone)
                    .addComponent(lblGuardAddress1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(txtPhone)
                        .addGap(170, 170, 170))
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(txtGuardPhone1)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(jspAddress1)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(txtIDno)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(jspAddress2)
                        .addGap(170, 170, 170))
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(txtGuardName2)
                        .addGap(170, 170, 170))
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(txtGuardPhone2)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dpDOReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGuardName1))
                        .addGap(170, 170, 170))
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStuName)
                            .addComponent(txtStuID)
                            .addComponent(txtBatch)
                            .addComponent(jspAddress)
                            .addComponent(dpDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(profPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkHostel)
                            .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblStuInfoHeading)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlStuPersonalInfoLayout.setVerticalGroup(
            pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblStuInfoHeading)
                .addGap(18, 18, 18)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStuID)
                            .addComponent(txtStuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStuName)
                            .addComponent(txtStuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDOB)
                            .addComponent(dpDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBatch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddress)
                            .addComponent(jspAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(profPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDOReg)
                    .addComponent(dpDOReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGuardName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuardName1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGuardPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuardPhone1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(jspAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGuardName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGuardName2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGuardPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGuardPhone2)))
                    .addComponent(lblGuardAddress1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStuPersonalInfoLayout.createSequentialGroup()
                        .addComponent(jspAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlStuPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkHostel)
                            .addComponent(lblHostel)))
                    .addComponent(lblGuardAddress2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStuPersonalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStuPersonalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        stu.setAccess(stuAccess);
        stu.setName(txtStuName.getText());
        stu.setDate(dpDOB.getDate());
        stu.setBatch(Integer.parseInt(txtBatch.getText()));
        stu.setAddress(txtAddress.getText());
        stu.setNIC(txtIDno.getText());
        stu.setPhone(Integer.parseInt(txtPhone.getText()));
        stu.setDate(dpDOReg.getDate());
        stu.setGuadian1Name(txtGuardName1.getText());
        stu.setGuadian1Address(txtGuardAddress1.getText());
        stu.setGuadian1Telephone(Integer.parseInt(txtGuardPhone1.getText()));
        stu.setGuadian2Name(txtGuardName2.getText());
        stu.setGuadian2Address(txtGuardAddress2.getText());
        stu.setGuadian2Telephone(Integer.parseInt(txtGuardPhone2.getText()));
        stu.setIsHostel(chkHostel.isSelected());
        try {
            stu.updateStudent();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EditStudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        GUIObserver.searchStudentbyID();
        this.setVisible(false);

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtGuardName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuardName1ActionPerformed

    private void chkHostelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHostelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkHostelActionPerformed

    private void txtGuardName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuardName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuardName2ActionPerformed

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
            File dest = new File(defaultDestinationPath.concat(Integer.toString(stu.getID())).concat(".png"));
            System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            try {
                Files.copy(Paths.get(source.getPath()), Paths.get(dest.getPath()),StandardCopyOption.REPLACE_EXISTING);
                stu.setPicture(defaultDestinationPath.concat(Integer.toString(stu.getID())).concat(".png"));
                startUpSettingData(stuAccess, Integer.toString(stu.getID()));
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
            java.util.logging.Logger.getLogger(EditStudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStudentInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStudentInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkHostel;
    private org.jdesktop.swingx.JXDatePicker dpDOB;
    private org.jdesktop.swingx.JXDatePicker dpDOReg;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jspAddress;
    private javax.swing.JScrollPane jspAddress1;
    private javax.swing.JScrollPane jspAddress2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDOReg;
    private javax.swing.JLabel lblGuardAddress1;
    private javax.swing.JLabel lblGuardAddress2;
    private javax.swing.JLabel lblGuardName1;
    private javax.swing.JLabel lblGuardName2;
    private javax.swing.JLabel lblGuardPhone1;
    private javax.swing.JLabel lblGuardPhone2;
    private javax.swing.JLabel lblHostel;
    private javax.swing.JLabel lblIDNo;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblStuID;
    private javax.swing.JLabel lblStuInfoHeading;
    private javax.swing.JLabel lblStuName;
    private javax.swing.JPanel pnlStuPersonalInfo;
    private javax.swing.JLabel profPicture;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtBatch;
    private javax.swing.JTextArea txtGuardAddress1;
    private javax.swing.JTextArea txtGuardAddress2;
    private javax.swing.JTextField txtGuardName1;
    private javax.swing.JTextField txtGuardName2;
    private javax.swing.JTextField txtGuardPhone1;
    private javax.swing.JTextField txtGuardPhone2;
    private javax.swing.JTextField txtIDno;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStuID;
    private javax.swing.JTextField txtStuName;
    // End of variables declaration//GEN-END:variables
}
