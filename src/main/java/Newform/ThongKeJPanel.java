/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Newform;

import DAO.DaoSanPham;
import DAO.ThongKeDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author adm
 */
public class ThongKeJPanel extends javax.swing.JPanel {

    DaoSanPham spdao = new DaoSanPham();
    ThongKeDAO tkdao = new ThongKeDAO();
    double tongDoanhThu=0;
    public ThongKeJPanel() {
        initComponents();
        fillTableSanPhamBanChayNhat();
        filltableSanPhamBanChamNhat();
    }

    public void filltableSanPhamBanChamNhat() {
        DefaultTableModel model = (DefaultTableModel) tblBanChayNhat.getModel();
        model.setRowCount(0);

        List<Object[]> list = tkdao.getSanPhamBanChayNhat();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void fillTableSanPhamBanChayNhat() {
        DefaultTableModel model = (DefaultTableModel) tblBanChamNhat.getModel();
        model.setRowCount(0);

        List<Object[]> list = tkdao.getSAnPhamBanChamNhat();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void FillTableDaonhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);

        // Lấy giá trị từ JTextField
        String ngayBatDauStr = txtNgayBatDau.getText();
        // Chuyển đổi ngày từ chuỗi sang đối tượng Date (cần xử lý exception)
        Date ngayBatDau = parseDateFromString(ngayBatDauStr);

        String ngayKetThucStr = txtNgayKetThuc.getText();
        // Chuyển đổi ngày từ chuỗi sang đối tượng Date (cần xử lý exception)
        Date ngayKetThuc = parseDateFromString(ngayKetThucStr);

        // Lấy giá trị từ JTextField cho ngày kết thúc tương tự nếu cần
        List<Object[]> list = tkdao.getThongKeDoanhThu(ngayBatDau, ngayKetThuc);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

// Phương thức hỗ trợ chuyển đổi chuỗi sang đối tượng Date
    private Date parseDateFromString(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Xử lý exception theo nhu cầu của bạn
            return null;
        }
    }

    public void selectTab(int index) {
        tabs.setSelectedIndex(index);
    }
private CategoryDataset createDataset(Date ngayBatDau, Date ngayKetThuc) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    List<Object[]> list = tkdao.getThongKeDoanhThu(ngayBatDau, ngayKetThuc);

    // Map để lưu tổng tiền của mỗi ngày
    Map<String, Double> dailyTotalMap = new HashMap<>();

    for (Object[] row : list) {
        // Giả sử phần tử thứ hai là một ngày
        Date date = (Date) row[1];

        // Bạn có thể cần định dạng ngày một cách phù hợp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String timePeriod = sdf.format(date);

        // Giả sử phần tử thứ ba là doanh thu
        double doanhThu = Double.parseDouble(row[2].toString());

        // Tính tổng tiền của mỗi ngày
        dailyTotalMap.merge(timePeriod, doanhThu, Double::sum);
    }

    // Thêm tổng tiền của mỗi ngày vào dataset
    for (Map.Entry<String, Double> entry : dailyTotalMap.entrySet()) {
        dataset.addValue(entry.getValue(), "VNĐ", entry.getKey());
    }

    return dataset;
}




  private JFreeChart createChart1(Date ngayBatDau, Date ngayKetThuc) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ DOANH THU",
                "Thời gian", "Doanh thu",
                createDataset1(ngayBatDau, ngayKetThuc), PlotOrientation.VERTICAL, false, false, false);
    return barChart;
    }

    private JFreeChart createChart(Date ngayBatDau, Date ngayKetThuc) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ DOANH THU",
                "Thời gian", "Doanh thu",
                createDataset(ngayBatDau, ngayKetThuc), PlotOrientation.VERTICAL, false, false, false);
    return barChart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTongHopThongKe = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlSanPhamBanChayNhat = new javax.swing.JPanel();
        pnlNguoiHoc = new javax.swing.JScrollPane();
        tblBanChayNhat = new javax.swing.JTable();
        pnlSanPhamBanChamNhat = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBanChamNhat = new javax.swing.JTable();
        pnlDoanhThu = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        txtNgayBatDau = new javax.swing.JTextField();
        txtNgayKetThuc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        btnTaoBieuDoDoanhThu = new javax.swing.JButton();
        txtNam = new javax.swing.JTextField();
        btnBieuDoTheoNam = new javax.swing.JButton();
        txtTongDoanhThu = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 0, 51));

        lblTongHopThongKe.setBackground(new java.awt.Color(255, 153, 0));
        lblTongHopThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongHopThongKe.setForeground(new java.awt.Color(255, 153, 0));
        lblTongHopThongKe.setText("TỔNG HỢP THỐNG KÊ");

        tabs.setBackground(new java.awt.Color(255, 204, 0));

        pnlSanPhamBanChayNhat.setBackground(new java.awt.Color(128, 188, 179));

        tblBanChayNhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng bán được"
            }
        ));
        pnlNguoiHoc.setViewportView(tblBanChayNhat);

        javax.swing.GroupLayout pnlSanPhamBanChayNhatLayout = new javax.swing.GroupLayout(pnlSanPhamBanChayNhat);
        pnlSanPhamBanChayNhat.setLayout(pnlSanPhamBanChayNhatLayout);
        pnlSanPhamBanChayNhatLayout.setHorizontalGroup(
            pnlSanPhamBanChayNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamBanChayNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSanPhamBanChayNhatLayout.setVerticalGroup(
            pnlSanPhamBanChayNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamBanChayNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        tabs.addTab("SẢN PHẨM BÁN CHẠY NHẤT", pnlSanPhamBanChayNhat);

        pnlSanPhamBanChamNhat.setBackground(new java.awt.Color(128, 188, 179));

        tblBanChamNhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng bán được"
            }
        ));
        jScrollPane3.setViewportView(tblBanChamNhat);

        javax.swing.GroupLayout pnlSanPhamBanChamNhatLayout = new javax.swing.GroupLayout(pnlSanPhamBanChamNhat);
        pnlSanPhamBanChamNhat.setLayout(pnlSanPhamBanChamNhatLayout);
        pnlSanPhamBanChamNhatLayout.setHorizontalGroup(
            pnlSanPhamBanChamNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamBanChamNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSanPhamBanChamNhatLayout.setVerticalGroup(
            pnlSanPhamBanChamNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamBanChamNhatLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 203, Short.MAX_VALUE))
        );

        tabs.addTab("SẢN PHẨM BÁN CHẬM NHẤT", pnlSanPhamBanChamNhat);

        pnlDoanhThu.setBackground(new java.awt.Color(128, 188, 179));

        tblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Ngày đặt", "Tổng tiền"
            }
        ));
        jScrollPane4.setViewportView(tblDoanhThu);

        txtNgayBatDau.setText("2023-01-01");
        txtNgayBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBatDauActionPerformed(evt);
            }
        });

        txtNgayKetThuc.setText("2023-12-31");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Ngày bắt đầu(yyyy-MM-dd)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("Ngày kết thúc(yyyy-MM-dd)");

        btnTimKiem.setBackground(new java.awt.Color(255, 204, 0));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnTaoBieuDoDoanhThu.setBackground(new java.awt.Color(255, 204, 0));
        btnTaoBieuDoDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoBieuDoDoanhThu.setText("Biểu đồ theo ngày");
        btnTaoBieuDoDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoBieuDoDoanhThuActionPerformed(evt);
            }
        });

        txtNam.setText("2023");
        txtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamActionPerformed(evt);
            }
        });

        btnBieuDoTheoNam.setBackground(new java.awt.Color(255, 204, 0));
        btnBieuDoTheoNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBieuDoTheoNam.setText("Biểu đồ theo tháng");
        btnBieuDoTheoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoTheoNamActionPerformed(evt);
            }
        });

        txtTongDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDoanhThuLayout = new javax.swing.GroupLayout(pnlDoanhThu);
        pnlDoanhThu.setLayout(pnlDoanhThuLayout);
        pnlDoanhThuLayout.setHorizontalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDoanhThuLayout.createSequentialGroup()
                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTaoBieuDoDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
                            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(44, 44, 44)
                                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnBieuDoTheoNam)
                                .addGap(30, 30, 30)
                                .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlDoanhThuLayout.setVerticalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBieuDoTheoNam)
                            .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaoBieuDoDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        tabs.addTab("DOANH THU", pnlDoanhThu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongHopThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongHopThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        FillTableDaonhThu(); 
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTaoBieuDoDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoBieuDoDoanhThuActionPerformed
        String ngayBatDauStr = txtNgayBatDau.getText();
        Date ngayBatDau = parseDateFromString(ngayBatDauStr);

        String ngayKetThucStr = txtNgayKetThuc.getText();
        Date ngayKetThuc = parseDateFromString(ngayKetThucStr);

        // Create and display the bar chart
        JFreeChart chart = createChart(ngayBatDau, ngayKetThuc);
        ChartPanel chartPanel = new ChartPanel(chart);

        // Display the chart in a new JFrame or another suitable container
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);// TODO add your handling code here: // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoBieuDoDoanhThuActionPerformed

    private void txtNgayBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBatDauActionPerformed

    private void txtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamActionPerformed
   private CategoryDataset createDataset1(Date ngayBatDau, Date ngayKetThuc) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Khởi tạo danh sách chứa doanh thu của các tháng từ 1 đến 12
    Map<String, Double> monthlyRevenueMap = new HashMap<>();
    for (int i = 10; i >=1; i--) {
        // Format tháng thành chuỗi "MM" (ví dụ: "01", "02", ..., "12")
        String monthString = String.format("%02d", i);
        // Gán giá trị mặc định là 0.0 cho tất cả các tháng
        monthlyRevenueMap.put(monthString, 0.0);
    }

    List<Object[]> list = tkdao.getThongKeDoanhThu(ngayBatDau, ngayKetThuc);

    // Cập nhật doanh thu cho các tháng có dữ liệu
    for (Object[] row : list) {
        // Giả sử phần tử thứ hai là một ngày
        Date date = (Date) row[1];
        // Lấy tháng từ ngày
        int month = getMonthFromDate(date);
        // Format tháng thành chuỗi "MM"
        String monthString = String.format("%02d", month);
        // Lấy doanh thu
        double doanhThu = Double.parseDouble(row[2].toString());
        // Cộng doanh thu vào tổng của tháng tương ứng
        monthlyRevenueMap.merge(monthString, doanhThu, Double::sum);
    }

    // Thêm doanh thu của từng tháng vào dataset
    for (Map.Entry<String, Double> entry : monthlyRevenueMap.entrySet()) {
        dataset.addValue(entry.getValue(), "VNĐ", entry.getKey());
    }

    return dataset;
}



// Phương thức để lấy tháng từ ngày
private int getMonthFromDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.MONTH) +1; // Giảm 1 để đảm bảo tháng từ 1 đến 12
}
private JFreeChart createChart1(int nam) {
    // Lấy dữ liệu từ stored procedure
    List<Object[]> list = tkdao.getThongKeDoanhThuTheoNam(nam);

    // Tạo dataset từ dữ liệu
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    Map<Integer, Double> monthlyTotalMap = new HashMap<>();

    for (Object[] row : list) {
        int thangDat = Integer.parseInt(row[1].toString());
        double tongDoanhThu = Double.parseDouble(row[2].toString());

        // Cộng dồn doanh thu cho mỗi tháng
        monthlyTotalMap.merge(thangDat, tongDoanhThu, Double::sum);
    }

    // Thêm tổng doanh thu của mỗi tháng vào dataset
    for (Map.Entry<Integer, Double> entry : monthlyTotalMap.entrySet()) {
        dataset.addValue(entry.getValue(), "VNĐ", String.valueOf(entry.getKey()));
    }

    // Tạo biểu đồ
    JFreeChart barChart = ChartFactory.createBarChart(
            "BIỂU ĐỒ DOANH THU",
            "Tháng", "Doanh thu",
            dataset, PlotOrientation.VERTICAL, true, true, false);

    return barChart;
}

    private void btnBieuDoTheoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoTheoNamActionPerformed
   String namStr = txtNam.getText();

    try {
        int nam = Integer.parseInt(namStr);

        // Tạo và hiển thị biểu đồ doanh thu với năm được chọn
        JFreeChart chart = createChart1(nam);
        ChartPanel chartPanel = new ChartPanel(chart);

        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập một năm hợp lệ.");
    }
    }//GEN-LAST:event_btnBieuDoTheoNamActionPerformed

    private void txtTongDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDoanhThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDoanhThuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDoTheoNam;
    private javax.swing.JButton btnTaoBieuDoDoanhThu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTongHopThongKe;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JScrollPane pnlNguoiHoc;
    private javax.swing.JPanel pnlSanPhamBanChamNhat;
    private javax.swing.JPanel pnlSanPhamBanChayNhat;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBanChamNhat;
    private javax.swing.JTable tblBanChayNhat;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtTongDoanhThu;
    // End of variables declaration//GEN-END:variables
}
