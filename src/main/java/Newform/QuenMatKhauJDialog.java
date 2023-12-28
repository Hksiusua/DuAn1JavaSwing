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
public class QuenMatKhauJDialog extends javax.swing.JDialog {

    DaoNhanVien dao = new DaoNhanVien();
    private String maXacThuc;
    NhanVien1 nv = new NhanVien1();
    private String maXacThucQuenMatKhau;

    public QuenMatKhauJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
//        init();

    }

    private String taoMaXacThuc() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        // Lưu mã xác thực vào biến
        maXacThuc = sb.toString();

        return maXacThuc;
    }

    private String guiEmailXacThuc(String maXacThuc, NhanVien1 nv) {
        final String username = "haianhx27@gmail.com";
        final String password = "nacm jzdh zxqb jarg";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Lấy địa chỉ email của nhân viên từ tham số truyền vào
        String emailNhanVien = nv.getEmail();
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        // Kiểm tra xem emailNhanVien có hợp lệ không
        if (emailNhanVien != null && !emailNhanVien.isEmpty()) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailNhanVien));
                message.setSubject("Xác thực đổi mật khẩu");
                message.setText("Mã xác thực của bạn là: " + maXacThuc);

                Transport.send(message);
                System.out.println("Email sent successfully to " + emailNhanVien);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid email address for the employee");
        }

        return maXacThuc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnKiemTra = new javax.swing.JButton();
        lblTaiKhoan = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));

        btnKiemTra.setBackground(new java.awt.Color(255, 255, 102));
        btnKiemTra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKiemTra.setText("Kiểm tra");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTaiKhoan.setText("Tên tài khoản");

        txtTaiKhoan.setBackground(new java.awt.Color(255, 204, 204));
        txtTaiKhoan.setText("NV001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 250));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        List<NhanVien1> list = dao.selectAll();
        String maNhanVienNhap = txtTaiKhoan.getText();
        boolean found = false;
        for (NhanVien1 nv : list) {
            if (maNhanVienNhap.equals(nv.getMaNV())) {
                maXacThucQuenMatKhau = taoMaXacThuc();
                guiEmailXacThuc(maXacThucQuenMatKhau, nv);
                found = true;
                // Lưu thông tin nhân viên vào Auth.user
                Auth.user = nv;
                // Mở form ĐoiMatKhau và truyền mã xác thực
                this.dispose();
                DoiMatKhau dialogDoiMatKhau = new DoiMatKhau((Frame) SwingUtilities.getWindowAncestor(this), true);
                dialogDoiMatKhau.setMaXacThucDoiMatKhau(maXacThucQuenMatKhau);
                dialogDoiMatKhau.setVisible(true);

                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã đã nhập.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnKiemTraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuenMatKhauJDialog dialog = new QuenMatKhauJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

}
