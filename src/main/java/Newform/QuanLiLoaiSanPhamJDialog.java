package Newform;

import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class QuanLiLoaiSanPhamJDialog extends javax.swing.JDialog {

    public QuanLiLoaiSanPhamJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
           if (parent == null) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlTraSua = new javax.swing.JPanel();
        btnTraSua = new javax.swing.JButton();
        lblHinhNhanVien = new javax.swing.JLabel();
        txtMaSP1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlDoUongKhac = new javax.swing.JPanel();
        btnDoUongKhac4 = new javax.swing.JButton();
        txtMaSP3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblHinhNhanVien1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTraSua.setBackground(new java.awt.Color(204, 0, 51));

        btnTraSua.setBackground(new java.awt.Color(255, 255, 102));
        btnTraSua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTraSua.setText("Trà sữa");
        btnTraSua.setFocusable(false);
        btnTraSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTraSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTraSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSuaActionPerformed(evt);
            }
        });

        lblHinhNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/LogoTraSua.jpg"))); // NOI18N
        lblHinhNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblHinhNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhNhanVienMouseClicked(evt);
            }
        });

        txtMaSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSP1.setText("LSP001");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("Mã loại: ");

        javax.swing.GroupLayout pnlTraSuaLayout = new javax.swing.GroupLayout(pnlTraSua);
        pnlTraSua.setLayout(pnlTraSuaLayout);
        pnlTraSuaLayout.setHorizontalGroup(
            pnlTraSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraSuaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTraSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTraSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTraSuaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(txtMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlTraSuaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblHinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTraSuaLayout.setVerticalGroup(
            pnlTraSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraSuaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlTraSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnTraSua, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlTraSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 290, 390));

        pnlDoUongKhac.setBackground(new java.awt.Color(204, 0, 51));

        btnDoUongKhac4.setBackground(new java.awt.Color(255, 255, 102));
        btnDoUongKhac4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDoUongKhac4.setText("Đồ uống khác");
        btnDoUongKhac4.setFocusable(false);
        btnDoUongKhac4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoUongKhac4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoUongKhac4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoUongKhac4ActionPerformed(evt);
            }
        });

        txtMaSP3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaSP3.setText("LSP002");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Mã loại: ");

        lblHinhNhanVien1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/Am.jpg"))); // NOI18N
        lblHinhNhanVien1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lblHinhNhanVien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhNhanVien1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDoUongKhacLayout = new javax.swing.GroupLayout(pnlDoUongKhac);
        pnlDoUongKhac.setLayout(pnlDoUongKhacLayout);
        pnlDoUongKhacLayout.setHorizontalGroup(
            pnlDoUongKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoUongKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoUongKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDoUongKhac4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDoUongKhacLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlDoUongKhacLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblHinhNhanVien1)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlDoUongKhacLayout.setVerticalGroup(
            pnlDoUongKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoUongKhacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDoUongKhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP3))
                .addGap(18, 18, 18)
                .addComponent(lblHinhNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDoUongKhac4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDoUongKhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 280, 390));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/QuanLiSP.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSuaActionPerformed
        OpenTraSua(0);

    }//GEN-LAST:event_btnTraSuaActionPerformed

    private void lblHinhNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhNhanVienMouseClicked

    }//GEN-LAST:event_lblHinhNhanVienMouseClicked

    private void btnDoUongKhac4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoUongKhac4ActionPerformed
            this.dispose();
        OpenDoUongKhac(1); // TODO add your handling code here:
    }//GEN-LAST:event_btnDoUongKhac4ActionPerformed

    private void lblHinhNhanVien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhNhanVien1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHinhNhanVien1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLiLoaiSanPhamJDialog dialog = new QuanLiLoaiSanPhamJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDoUongKhac4;
    private javax.swing.JButton btnTraSua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHinhNhanVien;
    private javax.swing.JLabel lblHinhNhanVien1;
    private javax.swing.JPanel pnlDoUongKhac;
    private javax.swing.JPanel pnlTraSua;
    private javax.swing.JTextField txtMaSP1;
    private javax.swing.JTextField txtMaSP3;
    // End of variables declaration//GEN-END:variables

    private void OpenTraSua(int index) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        Window ancestorWindow = SwingUtilities.getWindowAncestor(this);

        if (ancestorWindow instanceof JFrame) {
            JFrame parentFrame = (JFrame) ancestorWindow;
            SanPhamCodeTay1 tkwin = new SanPhamCodeTay1(parentFrame, true);
            tkwin.selectTab(index);
            tkwin.setVisible(true);
        } else {
            JFrame parentFrame = new JFrame();
            SanPhamCodeTay1 tkwin = new SanPhamCodeTay1(parentFrame, true);
            tkwin.selectTab(index);
            tkwin.setVisible(true);
        }
    }

    private void OpenDoUongKhac(int index) {
           try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        Window ancestorWindow = SwingUtilities.getWindowAncestor(this);
        if (ancestorWindow instanceof JFrame) {
            JFrame parentFrame = (JFrame) ancestorWindow;
            SanPhamCodeTay1 tkwin = new SanPhamCodeTay1(parentFrame, true);
            tkwin.selectTab(index);
            tkwin.setVisible(true);
        } else {
            JFrame parentFrame = new JFrame();
            SanPhamCodeTay1 tkwin = new SanPhamCodeTay1(parentFrame, true);
            tkwin.selectTab(index);
            tkwin.setVisible(true);
        }
    }
}
