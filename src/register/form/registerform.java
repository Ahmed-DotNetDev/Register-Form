package register.form;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class registerform extends javax.swing.JFrame {
    
    Connection con;
    DefaultTableModel dtm;
    ResultSet rs;
    ArrayList<Integer> departs = new ArrayList<>();
    ArrayList<Integer> empIds = new ArrayList<>();
    
    public registerform() throws SQLException, SQLException {
        
        initComponents();
        this.setTitle("Register form");
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Emp Name");
        dtm.addColumn("Emp Salary");
        dtm.addColumn("Emp Gender");
        dtm.addColumn("Depart Name");
        fillCombobox();
        fillTabel();
    }
    
    private void fillCombobox() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
            PreparedStatement pstm = con.prepareStatement("select department.deptId,department.deptName from department");
            rs = pstm.executeQuery();
            while (rs.next()) {
                departs.add(rs.getInt(1));
                cmbx_emp_depart.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed fillCombobox" + ex.getMessage());
        }
        
    }
    
    private void fillTabel() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
            dtm.setRowCount(0);
            PreparedStatement pstm = con.prepareStatement("select emplyee.empId, emplyee.empName,emplyee.salary,emplyee.gender,department.deptName from emplyee , department where emplyee.deptId=department.deptId;");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                empIds.add(rs.getInt(1));
                dtm.addRow(new Object[]{rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5)});
                tbl_show.setModel(dtm);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed fillTabel" + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edt_emp_name = new javax.swing.JTextField();
        edt_emp_salary = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbtn_male = new javax.swing.JRadioButton();
        rbtn_female = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cmbx_emp_depart = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_show = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        btn_off = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Employee Gender:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Employee Name:");

        edt_emp_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 1, true));

        edt_emp_salary.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Employee Salary:");

        buttonGroup1.add(rbtn_male);
        rbtn_male.setSelected(true);
        rbtn_male.setText("Male");
        rbtn_male.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.darkGray));
        rbtn_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_maleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_female);
        rbtn_female.setText("Female");
        rbtn_female.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.darkGray));
        rbtn_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_femaleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Department Names:");

        cmbx_emp_depart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbx_emp_depart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 71, 67), 2, true));

        tbl_show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_showMouse(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_show);

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\corporate-company-logo-749CEE6ADC-seeklogo.com.png")); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_off.setText("OFF");
        btn_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_offActionPerformed(evt);
            }
        });

        btn_delete1.setText("Delete");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(rbtn_male)
                                .addGap(18, 18, 18)
                                .addComponent(rbtn_female))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbx_emp_depart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(148, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edt_emp_salary)
                                    .addComponent(edt_emp_name))))
                        .addGap(17, 17, 17))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_off, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(edt_emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edt_emp_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtn_male)
                    .addComponent(rbtn_female))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbx_emp_depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_off, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btn_delete1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void rbtn_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_femaleActionPerformed

    private void rbtn_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_maleActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (!edt_emp_name.getText().isEmpty() && !edt_emp_salary.getText().isEmpty()) {
            
            try {
                String empName = edt_emp_name.getText();
                double empSalary = Double.parseDouble(edt_emp_salary.getText());
                String gender;
                if (rbtn_male.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
                PreparedStatement pst = con.prepareStatement("insert into emplyee(empName,salary,gender,deptId) values (?,?,?,?)");
                pst.setString(1, empName);
                pst.setDouble(2, empSalary);
                pst.setString(3, gender);
                pst.setInt(4, departs.get(cmbx_emp_depart.getSelectedIndex()));
                pst.executeUpdate();
                fillTabel();
                JOptionPane.showMessageDialog(this, "Success Insertion");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR IN ADD ACTION");
            }
            
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (!edt_emp_name.getText().isEmpty() && !edt_emp_salary.getText().isEmpty()) {
            
            try {
                String empName = edt_emp_name.getText();
                double empSalary = Double.parseDouble(edt_emp_salary.getText());
                String gender;
                if (rbtn_male.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
                PreparedStatement pst = con.prepareStatement("update emplyee set empName=?,salary=?,gender=?,deptId=? where empId=?");
                pst.setString(1, empName);
                pst.setDouble(2, empSalary);
                pst.setString(3, gender);
                pst.setInt(4, departs.get(cmbx_emp_depart.getSelectedIndex()));
                pst.setInt(5, empIds.get(tbl_show.getSelectedRow()));
                pst.executeUpdate();
                fillTabel();
                JOptionPane.showMessageDialog(this, "Success Update");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR IN UPDATE ACTION");
            }
            
        }
    }
    
    private void tbl_showMouseClicked(java.awt.event.MouseEvent evt) {
        edt_emp_name.setText(tbl_show.getValueAt(tbl_show.getSelectedRow(), 0).toString());
        edt_emp_salary.setText(tbl_show.getValueAt(tbl_show.getSelectedRow(), 1).toString());
        
        if (tbl_show.getValueAt(tbl_show.getSelectedRow(), 2) != null) {
            if (tbl_show.getValueAt(tbl_show.getSelectedRow(), 2).toString().equals("female")) {
                rbtn_female.setSelected(true);
            } else {
                rbtn_male.setSelected(true);
            }
            cmbx_emp_depart.setSelectedItem(tbl_show.getValueAt(tbl_show.getSelectedRow(), 3));
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_showMouse(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_showMouse
        edt_emp_name.setText(tbl_show.getValueAt(tbl_show.getSelectedRow(), 0).toString());
        edt_emp_salary.setText(tbl_show.getValueAt(tbl_show.getSelectedRow(), 1).toString());
        
        if (tbl_show.getValueAt(tbl_show.getSelectedRow(), 2) != null) {
            if (tbl_show.getValueAt(tbl_show.getSelectedRow(), 2).toString().equals("female")) {
                rbtn_female.setSelected(true);
            } else {
                rbtn_male.setSelected(true);
            }
            cmbx_emp_depart.setSelectedItem(tbl_show.getValueAt(tbl_show.getSelectedRow(), 3));
        }
    }//GEN-LAST:event_tbl_showMouse

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        if (!edt_emp_name.getText().isEmpty() && !edt_emp_salary.getText().isEmpty()) {
            
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");
                PreparedStatement pst = con.prepareStatement("delete from emplyee where empId =?");
                pst.setInt(1, empIds.get(tbl_show.getSelectedRow()));
                pst.executeUpdate();
                fillTabel();
                JOptionPane.showMessageDialog(this, "Success Delete");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR IN Delete ACTION");
            }
            
        }
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void btn_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_offActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_offActionPerformed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new registerform().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(registerform.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_off;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbx_emp_depart;
    private javax.swing.JTextField edt_emp_name;
    private javax.swing.JTextField edt_emp_salary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn_female;
    private javax.swing.JRadioButton rbtn_male;
    private javax.swing.JTable tbl_show;
    // End of variables declaration//GEN-END:variables
}
