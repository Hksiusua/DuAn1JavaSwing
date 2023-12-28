/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Newform;

import DAO.ChiTietDonHangDAO;
import DAO.DonHangDAO;
import Entity.ChiTietDonHang;
import Entity.DonHang;
import Util.MsgBox;
import Util.XImage;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adm
 */
public class ChiTietDonHangJDialogLienKet1 extends javax.swing.JDialog {

    private int row = 0;
    private ChiTietDonHangDAO ctdhdao = new ChiTietDonHangDAO();
    private DonHangDAO dhdao = new DonHangDAO();
    private JFileChooser fileChooser = new JFileChooser();

    public ChiTietDonHangJDialogLienKet1(java.awt.Frame parent, boolean modal, DonHang selectedDonHang) {
        super(parent, modal);
        initComponents();
        init();
        this.fillComboBoxDonHang(selectedDonHang);
        cboDonHang.setSelectedItem(selectedDonHang);
        int ChiTietDonHang = (int) tblChiTietDonHang.getValueAt(row, 0);
        ChiTietDonHang nh = ctdhdao.selectById((int) ChiTietDonHang);
        tblChiTietDonHang.setRowSelectionInterval(row, row);
        this.setForm(nh);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cboDonHang = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pnlCapNhat = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenDonhang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        txtMaHoaDonChiTiet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        btnMoi1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        lblhinh = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietDonHang = new javax.swing.JTable();
        btnTraiCuoi = new javax.swing.JButton();
        btnTrai = new javax.swing.JButton();
        btnphai = new javax.swing.JButton();
        btncuoiPhai = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        btnXuatHoaDon = new javax.swing.JButton();

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/add_insert_new_plus_button_icon_142943.png"))); // NOI18N
        btnThem.setText("Thêm ");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/emblemsynchronizing_93485.png"))); // NOI18N
        btnSua.setText("Sửa");

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/add_insert_new_plus_button_icon_142943.png"))); // NOI18N
        btnMoi.setText("Mới");

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/seo-social-web-network-internet_262_icon-icons.com_61518.png"))); // NOI18N
        btnXoa.setText("Xóa");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        jPanel2.setBackground(new java.awt.Color(153, 0, 51));

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 204, 0));

        cboDonHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDonHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(cboDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setBackground(new java.awt.Color(255, 153, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Giỏ hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 273, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCapNhat.setBackground(new java.awt.Color(128, 188, 179));

        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Tên đơn hàng");

        jLabel6.setForeground(new java.awt.Color(51, 51, 0));
        jLabel6.setText("Số lượng");

        jLabel7.setForeground(new java.awt.Color(51, 51, 0));
        jLabel7.setText("Đơn giá");

        jLabel8.setForeground(new java.awt.Color(51, 51, 0));
        jLabel8.setText("Giảm giá");

        jLabel9.setForeground(new java.awt.Color(51, 51, 0));
        jLabel9.setText("Mã sản phẩm");

        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Mã hóa đơn chi tiết:");

        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/add_insert_new_plus_button_icon_142943.png"))); // NOI18N
        btnThem1.setText("Thêm ");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/emblemsynchronizing_93485.png"))); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        btnMoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/add_insert_new_plus_button_icon_142943.png"))); // NOI18N
        btnMoi1.setText("Mới");
        btnMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoi1ActionPerformed(evt);
            }
        });

        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/seo-social-web-network-internet_262_icon-icons.com_61518.png"))); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        lblhinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/landscape-image_icon-icons.com_53961.png"))); // NOI18N
        lblhinh.setText("Hình");
        lblhinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblhinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhinhMouseClicked(evt);
            }
        });

        tblChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChiTietDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietDonHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietDonHang);

        btnTraiCuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/icFirst.png"))); // NOI18N
        btnTraiCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraiCuoiActionPerformed(evt);
            }
        });

        btnTrai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/back-arrow_icon-icons.com_54057.png"))); // NOI18N
        btnTrai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraiActionPerformed(evt);
            }
        });

        btnphai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/right-arrow-circle_icon-icons.com_53897.png"))); // NOI18N
        btnphai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphaiActionPerformed(evt);
            }
        });

        btncuoiPhai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/Icon/icLast.png"))); // NOI18N
        btncuoiPhai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncuoiPhaiActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(51, 51, 0));
        jLabel3.setText("Tên sản phẩm");

        btnXuatHoaDon.setBackground(new java.awt.Color(255, 204, 0));
        btnXuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem1)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnTraiCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnTrai, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnphai, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoi1)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btncuoiPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHoaDonChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenDonhang, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtMaSanPham)))
                                .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtDonGia))))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addComponent(txtTenSanPham)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaHoaDonChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenDonhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblhinh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem1)
                            .addComponent(btnSua1)
                            .addComponent(btnXoa1)
                            .addComponent(btnMoi1))
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTraiCuoi)
                                    .addComponent(btnTrai)
                                    .addComponent(btnphai)))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btncuoiPhai)))
                        .addGap(13, 13, 13))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChiTietDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietDonHangMouseClicked
        this.row = tblChiTietDonHang.rowAtPoint(evt.getPoint());
        edit(); // TODO add your handling code here:
    }//GEN-LAST:event_tblChiTietDonHangMouseClicked

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        update();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void cboDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDonHangActionPerformed
        reloadKhoaHocTable();        // TODO add your handling code here:
    }//GEN-LAST:event_cboDonHangActionPerformed

    private void lblhinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhinhMouseClicked
        if (evt.getClickCount() == 2) {

            chonAnh();
        }         
    }//GEN-LAST:event_lblhinhMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        insert();    // TODO add your handling code here:
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        delete();        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi1ActionPerformed
        clearForm();            // TODO add your handling code here:
    }//GEN-LAST:event_btnMoi1ActionPerformed

    private void btnTraiCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraiCuoiActionPerformed
        row = 0;
        edit();
    }//GEN-LAST:event_btnTraiCuoiActionPerformed

    private void btnphaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphaiActionPerformed
        if (row < tblChiTietDonHang.getRowCount() - 1) {
            row++;
            edit();
        }
    }//GEN-LAST:event_btnphaiActionPerformed

    private void btncuoiPhaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncuoiPhaiActionPerformed
        row = tblChiTietDonHang.getRowCount() - 1;
        edit();
    }//GEN-LAST:event_btncuoiPhaiActionPerformed

    private void btnTraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraiActionPerformed

        if (row > 0) {
            row--;
            edit();
        }
    }//GEN-LAST:event_btnTraiActionPerformed

    private List<ChiTietDonHang> getChiTietDonHangData() {
        List<ChiTietDonHang> chiTietDonHangList = new ArrayList<>();
        DefaultTableModel tblmodel = (DefaultTableModel) tblChiTietDonHang.getModel();
        for (int i = 0; i < tblmodel.getRowCount(); i++) {
            int maChiTietDH = Integer.parseInt(tblmodel.getValueAt(i, 0).toString());
            String maDH = tblmodel.getValueAt(i, 1).toString();
            String maSP = tblmodel.getValueAt(i, 2).toString();
            String tenSP = tblmodel.getValueAt(i, 3).toString();
            int soLuong = Integer.parseInt(tblmodel.getValueAt(i, 4).toString());
            double donGia = Double.parseDouble(tblmodel.getValueAt(i, 5).toString());
            double giamGia = Double.parseDouble(tblmodel.getValueAt(i, 6).toString());
//        String hinh = tblmodel.getValueAt(i, 7).toString();

            ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDH, maDH, maSP, tenSP, soLuong, donGia, giamGia);
            chiTietDonHangList.add(chiTietDonHang);
        }

        return chiTietDonHangList;
    }
    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed

        List<ChiTietDonHang> chiTietDonHangList = getChiTietDonHangData();
        HoaDonJDialog hoaDonDialog = new HoaDonJDialog((Frame) SwingUtilities.getWindowAncestor(this), true);
        hoaDonDialog.displayChiTietDonHangData(chiTietDonHangList);
        hoaDonDialog.setVisible(true);

    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietDonHangJDialogLienKet1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            // Create a sample DonHang instance (replace this with your actual DonHang data)
            DonHang sampleDonHang = new DonHang();
            // Set properties of the sampleDonHang if needed...

            // Pass the sampleDonHang to the ChiTietDonHangJDialog constructor
            ChiTietDonHangJDialogLienKet1 dialog = new ChiTietDonHangJDialogLienKet1(new javax.swing.JFrame(), true, sampleDonHang);

            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });

            dialog.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMoi1;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTrai;
    private javax.swing.JButton btnTraiCuoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton btncuoiPhai;
    private javax.swing.JButton btnphai;
    private javax.swing.JComboBox<String> cboDonHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblhinh;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JTable tblChiTietDonHang;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHoaDonChiTiet;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDonhang;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
private void reloadKhoaHocTable() {
        DefaultTableModel tblmodel = (DefaultTableModel) tblChiTietDonHang.getModel();
        tblmodel.setRowCount(0);
        DonHang dh = (DonHang) cboDonHang.getSelectedItem();
        if (dh != null) {
            List<ChiTietDonHang> list = ctdhdao.selectByDonHang(dh.getMaDH());
            if (list != null) {
                for (ChiTietDonHang ctdh : list) {
                    double thanhTien = ctdh.getSoLuong() * ctdh.getDonGia() * (1 - ctdh.getGiamGia() / 100);
                    Object row[] = {ctdh.getMaChiTietDH(), ctdh.getMaDH(), ctdh.getMaSP(), ctdh.getTenSP(), ctdh.getSoLuong(), ctdh.getDonGia(), ctdh.getGiamGia(), thanhTien};
                    tblmodel.addRow(row);
                }
                // Lấy thông tin sản phẩm từ hàng đầu tiên trong bảng và hiển thị trong txtArea
            }
        }
    }

    private void init() {
        this.setLocationRelativeTo(null);

        DefaultTableModel tblmodel = new DefaultTableModel();
        String col[] = {"MÃ CHI TIẾT", "MÃ HÓA ĐƠN", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "ĐƠN GIÁ ", "GIẢM GIÁ", "THÀNH TIỀN"};
        tblmodel.setColumnIdentifiers(col);
        tblChiTietDonHang.setModel(tblmodel);

    }


    private void fillComboBoxDonHang(DonHang selectedDonHang) {
        DefaultComboBoxModel tblmodel = (DefaultComboBoxModel) cboDonHang.getModel();
        tblmodel.removeAllElements();

        // Add the selectedDonHang to the ComboBox model
        tblmodel.addElement(selectedDonHang);

        // Set the selected item in the ComboBox
        cboDonHang.setSelectedItem(selectedDonHang);

        // Thêm sự kiện lắng nghe sự thay đổi của ComboBox (if needed)
        cboDonHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DonHang selectedChuyenDe = (DonHang) cboDonHang.getSelectedItem();
                if (selectedChuyenDe != null) {
                    txtTenDonhang.setText(selectedChuyenDe.getMaDH());
                }
            }
        });
    }

    private void setForm(ChiTietDonHang nh) {
        txtMaHoaDonChiTiet.setText(Integer.toString(nh.getMaChiTietDH()));
        txtDonGia.setText(Double.toString(nh.getDonGia()));
        txtTenSanPham.setText(nh.getTenSP());
        txtTenDonhang.setText(nh.getMaDH());
        txtSoLuong.setText(Integer.toString(nh.getSoLuong()));
        txtGiamGia.setText(Double.toString(nh.getGiamGia()));
        txtMaSanPham.setText(nh.getMaSP());
        String hinh = nh.getHinh();
        if (hinh != null && !hinh.equals("")) {
            lblhinh.setIcon(XImage.read(hinh));
            lblhinh.setToolTipText(hinh);
        }
    }

    private void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Chỉnh sửa ảnh trước khi hiển thị
            ImageIcon icon = XImage.read(file.getName());
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(lblhinh.getWidth(), lblhinh.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            // Hiển thị ảnh
            lblhinh.setIcon(icon);
            lblhinh.setToolTipText(file.getName());
        }
    }

    private ChiTietDonHang getForm() {
        ChiTietDonHang kh = new ChiTietDonHang();
        DonHang selectedDonHang = (DonHang) cboDonHang.getSelectedItem();
        String maDH = selectedDonHang.getMaDH();
        kh.setMaDH(maDH);
        kh.setTenSP(txtTenSanPham.getText());

        kh.setDonGia(Double.parseDouble(txtDonGia.getText()));
        kh.setGiamGia(Double.parseDouble(txtGiamGia.getText()));
        kh.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        kh.setMaSP(txtMaSanPham.getText());
        kh.setHinh(lblhinh.getToolTipText());

        return kh;
    }

    private void edit() {
        int ChiTietDonHang = (int) tblChiTietDonHang.getValueAt(row, 0);
        ChiTietDonHang nh = ctdhdao.selectById((int) ChiTietDonHang);
        tblChiTietDonHang.setRowSelectionInterval(row, row);
        this.setForm(nh);
    }

    private void insert() {

        try {
            ChiTietDonHang ctdh = getForm();
            ctdhdao.insert(ctdh);
            reloadKhoaHocTable();
            clearForm();
            MsgBox.alert(this, "thêm thàn công");
        } catch (Exception e) {
            MsgBox.alert(this, "thêm thất bại ");
            e.printStackTrace();

        }
    }

    private void delete() {
        for (int row : tblChiTietDonHang.getSelectedRows()) {
            int maChiTiet = (int) tblChiTietDonHang.getValueAt(row, 0);
            ctdhdao.delete(maChiTiet);
            this.reloadKhoaHocTable();
            clearForm();
            MsgBox.alert(this, "Xóa thành công");
        }

    }

    private void update() {
        ChiTietDonHang kh = getForm();
        ctdhdao.update(kh);
        // Cập nhật bảng và làm sạch form
        this.reloadKhoaHocTable();
        clearForm();
        MsgBox.alert(this, "Cập nhật thành công");
    }

    public void setProductDetailsInLabels(String maSP, String tenSP, String gia, String phanTramGiamGia, String hinh) {
        // Kiểm tra null để tránh lỗi NullPointerException
        if (txtMaSanPham != null && txtTenSanPham != null && txtDonGia != null && txtGiamGia != null && lblhinh != null) {
            txtMaSanPham.setText(maSP);
            txtTenSanPham.setText(tenSP);
            txtDonGia.setText(gia);
            txtGiamGia.setText(phanTramGiamGia);

            // Đặt hình cho lblhinh
            if (hinh != null && !hinh.equals("")) {
                lblhinh.setIcon(XImage.read(hinh));
                lblhinh.setToolTipText(hinh);
            }

            // Các nhãn khác có thể được thêm vào tùy theo nhu cầu
        } else {
            System.out.println("One or more components are null.");
        }
    }

    // Các phương thức và thuộc tính khác của lớp
    private void clearForm() {
        txtMaHoaDonChiTiet.setText("");
        txtDonGia.setText("");
        txtTenDonhang.setText("");
        txtSoLuong.setText("");
        txtGiamGia.setText("");
        txtTenDonhang.setText("");
        txtMaSanPham.setText("");
        lblhinh.setIcon(null);
        lblhinh.setToolTipText("");
    }

}
