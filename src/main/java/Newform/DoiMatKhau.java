/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Newform;

import DAO.DaoNhanVien;
import Entity.NhanVien1;
import Util.Auth;
import Util.MsgBox;
import java.awt.Frame;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author adm
 */
public class DoiMatKhau extends javax.swing.JDialog {

    DaoNhanVien dao = new DaoNhanVien();

    NhanVien1 nv = new NhanVien1();
    private String maXacThucDoiMatKhau;

    public DoiMatKhau(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnDoiMatKhau = new javax.swing.JButton();
        lblTaiKhoan = new javax.swing.JLabel();
        txtMaXacThuc = new javax.swing.JTextField();
        lblTaiKhoan1 = new javax.swing.JLabel();
        txtDoiMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));

        btnDoiMatKhau.setBackground(new java.awt.Color(255, 255, 102));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaiKhoan.setText("Mã xác thực");

        txtMaXacThuc.setBackground(new java.awt.Color(255, 204, 204));

        lblTaiKhoan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaiKhoan1.setText("Mật khẩu mới");

        txtDoiMatKhau.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDoiMatKhau)
                    .addComponent(lblTaiKhoan1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaXacThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaXacThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTaiKhoan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setMaXacThucDoiMatKhau(String maXacThuc) {
        this.maXacThucDoiMatKhau = maXacThuc;
    }

    private void doiMatKhau(String maXacThuc, String matKhauMoi) {
        // Kiểm tra xác thực trước khi đổi mật khẩu
        if (!maXacThuc.equals(maXacThucDoiMatKhau)) {
            MsgBox.alert(this, "Mã xác thực không đúng. Vui lòng kiểm tra lại.");
            return;
        }

        // Kiểm tra độ dài mật khẩu mới hoặc các yêu cầu khác nếu cần
        // Cập nhật mật khẩu cho người dùng hiện tại
        Auth.user.setMatKhau(matKhauMoi);
        dao.update(Auth.user);

        // Thông báo thành công và thực hiện các bước khác nếu cần
        MsgBox.alert(this, "Đổi mật khẩu thành công.");

        // Đóng cửa sổ JDialog sau khi đổi mật khẩu
    }

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed

        String maXacThuc = new String(txtMaXacThuc.getText());
        String matKhauMoi = new String(txtDoiMatKhau.getText());

        // Gọi hàm đổi mật khẩu
        doiMatKhau(maXacThuc, matKhauMoi);
        this.dispose();
        DangNhapJDialog dialogQuenMatKhau = new DangNhapJDialog((Frame) SwingUtilities.getWindowAncestor(this), true);
        dialogQuenMatKhau.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiMatKhau dialog = new DoiMatKhau(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTaiKhoan1;
    private javax.swing.JPasswordField txtDoiMatKhau;
    private javax.swing.JTextField txtMaXacThuc;
    // End of variables declaration//GEN-END:variables

}
