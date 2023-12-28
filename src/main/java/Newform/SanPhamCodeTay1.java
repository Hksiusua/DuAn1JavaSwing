package Newform;

/**
 *
 * @author adm
 */
import DAO.ChiTietDonHangDAO;
import DAO.DaoSanPham;
import DAO.DonHangDAO;
import Entity.ChiTietDonHang;
import Entity.DonHang;
import Entity.SanPham;
import Util.MsgBox;
import Util.XImage;
//import com.edusys.ui.ChiTietDonHang1JDialog;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SanPhamCodeTay1 extends javax.swing.JDialog {

    private ChiTietDonHangDAO CTdao = new ChiTietDonHangDAO();
    private DaoSanPham Spdao = new DaoSanPham();
    private DonHangDAO DHdao = new DonHangDAO();
    private JFileChooser fileChooser = new JFileChooser();
    private int row = 0;
    private JTabbedPane tabbedPane;
    private JLabel lblMaSP;
    private JLabel lblMaLoai;
    private JLabel lblTenSP;
    private JLabel lblGia;
    private JLabel lblPhanTramGiamGia;
    private JLabel lblHinh;
    private JLabel lblDonHang;
    private JLabel lblSoLuong;
    private JTextField txtSoLuong;
    private JComboBox<String> cboLoaiSanPham;

    private JPanel hoaDonPanel;  // Thêm JPanel cho việc hiển thị Hóa đơn
    private JTextField txtMaSP;
    private JTextField txtMaLoai;
    private JTextField txtTenSP;
    private JTextField txtGia;
    private JTextField txtPhanTramGiamGia;
    private JPanel itemPanel;
//    private JButton btnadddata;
    // Thêm combobox để chọn Mã Đơn Hàng
    private JTable tblFillTable = new JTable();
    JComboBox<String> cboDonHang;
    SpinnerNumberModel spinnerModel;
    JSpinner spinnerSoLuong;
    private List<JPanel> danhSachSanPhamDaThem = new ArrayList<>();


    public SanPhamCodeTay1(JFrame jFrame, boolean par) {
        // Khởi tạo frame
        setTitle("Quản Lý Sản Phẩm");
        setSize(1300, 820);
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        hoaDonPanel = new JPanel();
        hoaDonPanel.setLayout(new BoxLayout(hoaDonPanel, BoxLayout.Y_AXIS));
        // Tạo JTabbedPane
        tabbedPane = new JTabbedPane();
        add(tabbedPane);
        // Thêm các tab vào JTabbedPane
        tabbedPane.addTab("Quản lý sản phẩm", createFillTablePanel());
        tabbedPane.addTab("Sản phẩm LSP001", createSanphamPanel(Integer.MAX_VALUE, "LSP001"));
        tabbedPane.addTab("Sản phẩm LSP002", createSanphamPanel(Integer.MAX_VALUE, "LSP002"));

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        this.fillComboBoxDonHanng();
        String MaSanPham = (String) tblFillTable.getValueAt(row, 0);
        SanPham nh = Spdao.selectById(MaSanPham);
        tblFillTable.setRowSelectionInterval(0, 0);
        this.setForm(nh);
        setVisible(true);
    }
    
      private void fillComboBoxDonHanng() {
        DefaultComboBoxModel tblmodel = (DefaultComboBoxModel) cboDonHang.getModel();
        tblmodel.removeAllElements();
        List<DonHang> list = DHdao.selectAll();
        for (DonHang cd : list) {
            tblmodel.addElement(cd);
        }
    }
        public void setMaDonHang(String maDonHang) {
        cboDonHang.setSelectedItem(maDonHang);
    }
    private JPanel createFillTablePanel() {
        JPanel fillTablePanel = new JPanel(new BorderLayout());

        cboLoaiSanPham = new JComboBox<>();
        populateLoaiSanPhamComboBox();
        lblDonHang = new JLabel("Đơn hàng"); // Tạo các JLabel
        lblMaSP = new JLabel("Mã SP:");
        lblMaLoai = new JLabel("Mã Loại:");
        lblTenSP = new JLabel("Tên SP:");
        lblGia = new JLabel("Giá:");
        lblPhanTramGiamGia = new JLabel("Phần trăm giảm giá:");
        lblHinh = new JLabel();
        lblSoLuong = new JLabel("Số lượng");
        // Tạo Border cho lblHinhAnh
        Border border = BorderFactory.createLineBorder(Color.BLACK); // Màu đen, bạn có thể thay đổi màu sắc nếu cần
// Tạo JLabel với Border
        lblHinh.setBorder(border);
        lblHinh.setPreferredSize(new Dimension(300, 165));
        // Tạo các JTextField
        txtMaSP = new JTextField();
        txtMaLoai = new JTextField();
        txtTenSP = new JTextField();
        txtGia = new JTextField();
        txtPhanTramGiamGia = new JTextField();
        txtSoLuong = new JTextField();
        txtSoLuong.setEditable(false);
        // Tạo nút "Thêm"
        JButton btnThem = new JButton("Thêm");
        // Tạo nút "Sửa"
        JButton btnSua = new JButton("Sửa");
        // Tạo nút "Xóa"
        JButton btnXoa = new JButton("Xóa");
        JButton btnGioHang = new JButton("Giỏ hàng");
        JPanel pnlNutDieuKhien = new JPanel(new FlowLayout());
        JButton btnTraiCuoi = new JButton("<");
        JButton btnTrai = new JButton("<<");
        JButton btnPhai = new JButton(">>");
        JButton btnPhaiCuoi = new JButton(">");
        pnlNutDieuKhien.add(btnTraiCuoi);
        pnlNutDieuKhien.add(btnTrai);
        pnlNutDieuKhien.add(btnPhai);
        pnlNutDieuKhien.add(btnPhaiCuoi);

        // Tạo bảng fillTable
        DefaultTableModel tblmodel = new DefaultTableModel();
        String col[] = {"MaSP", "MaLoai", "TenSP", "Gia", "PhanTramGiamGia", "Hinh"};
        tblmodel.setColumnIdentifiers(col);
        spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

        tblFillTable = new JTable(tblmodel);
        // Đặt layout cho fillTablePanel
        fillTablePanel.setLayout(new BorderLayout());

        JPanel HinhAnhJpanel = new JPanel(new GridLayout(2, 4));
        HinhAnhJpanel.add(lblHinh);
        HinhAnhJpanel.add(pnlNutDieuKhien);
        // Thêm các thành phần vào fillTablePanel
     String[] items = {};
        cboDonHang = new JComboBox<>(items);

        // Thêm sự kiện lắng nghe để xử lý khi người dùng chọn một mục trong JComboBox
         cboDonHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện ở đây

                System.out.println("Selected Item: " + cboDonHang.getSelectedItem());

                // Gọi hàm fillComboBoxChuyenDe() khi có sự kiện thay đổi
            }
        });
        JPanel inputPanel = new JPanel(new GridLayout(4, 4));
        inputPanel.add(lblDonHang);
        inputPanel.add(cboDonHang);

        inputPanel.add(lblMaLoai);
        inputPanel.add(cboLoaiSanPham);
        inputPanel.add(lblMaSP);
        inputPanel.add(txtMaSP);
        inputPanel.add(lblTenSP);
        inputPanel.add(txtTenSP);
        inputPanel.add(lblGia);
        inputPanel.add(txtGia);
        inputPanel.add(lblPhanTramGiamGia);
        inputPanel.add(txtPhanTramGiamGia);
        inputPanel.add(lblSoLuong);
        inputPanel.add(txtSoLuong);

        inputPanel.add(new JLabel());  // Để tạo một ô trống cho việc hiển thị hình ảnh

        JPanel buttonPanel = new JPanel(new FlowLayout());
        Dimension btnSize = new Dimension(90, 40);
        btnGioHang.setPreferredSize(btnSize);
        btnThem.setPreferredSize(btnSize);
        btnSua.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);

        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnGioHang);
        fillTablePanel.add(HinhAnhJpanel, BorderLayout.EAST);
        fillTablePanel.add(inputPanel, BorderLayout.NORTH);
        fillTablePanel.add(new JScrollPane(tblFillTable), BorderLayout.CENTER);
        fillTablePanel.add(buttonPanel, BorderLayout.SOUTH);
        btnGioHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Thêm" được nhấn
                // Thêm dữ liệu từ form vào cơ sở dữ liệu
                ChiTietDonHangJDialog1 dialogQuenMatKhau = new ChiTietDonHangJDialog1(null, rootPaneCheckingEnabled);
                dialogQuenMatKhau.setVisible(true);
            }
        });
        // Thêm sự kiện cho nút "Thêm" (btnThem)
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                insert();
                // Gọi hàm fillTable để cập nhật dữ liệu trong bảng
                fillTable();
            }
        });

// Thêm sự kiện cho nút "Sửa" (btnSua)
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Sửa" được nhấn
                // Lấy dữ liệu từ form và cập nhật vào cơ sở dữ liệu
                update();
                // Gọi hàm fillTable để cập nhật dữ liệu trong bảng
                fillTable();
            }
        });

// Thêm sự kiện cho nút "Xóa" (btnXoa)
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Xóa" được nhấn
                // Xóa dữ liệu từ cơ sở dữ liệu
                delete();
                // Gọi hàm fillTable để cập nhật dữ liệu trong bảng
                fillTable();
            }
        });
        btnTraiCuoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Xóa" được nhấn
                // Xóa dữ liệu từ cơ sở dữ liệu
                row = 0;
                edit();
                tblFillTable.setRowSelectionInterval(row, row);
            }
        });
        btnTrai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Xóa" được nhấn
                if (row > 0) {
                    row--;
                    edit();
                    tblFillTable.setRowSelectionInterval(row, row);
                }
            }
        });

        btnPhai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (row < tblFillTable.getRowCount() - 1) {
                    row++;
                    edit();
                    tblFillTable.setRowSelectionInterval(row, row);
                }
            }
        });
        btnPhaiCuoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Xóa" được nhấn
                // Xóa dữ liệu từ cơ sở dữ liệu
                row = tblFillTable.getRowCount() - 1;
                edit();
                tblFillTable.setRowSelectionInterval(row, row);
            }
        });
        // Thêm sự kiện cho JTable (tblFillTable) khi người dùng chọn một hàng
        tblFillTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tblFillTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        try {
                            // Lấy thông tin từ hàng được chọn
                            String maSP = tblFillTable.getValueAt(selectedRow, 0).toString();
                            SanPham selectedSP = Spdao.selectById(maSP);

                            // Hiển thị thông tin lên các trường JTextField
                            setForm(selectedSP);

                            // Hiển thị hình ảnh từ đường dẫn trong cột "Hinh"
                            String imagePath = tblFillTable.getValueAt(selectedRow, 5).toString();

                            // Tạo ImageIcon với kích thước đã thay đổi
                            ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH));
//  lblHinh.setIcon(icon);
                            // Set Tooltip và không setIcon
                            lblHinh.setToolTipText(imagePath);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        lblHinh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chonAnh();
            }
        });

        fillTable();

        return fillTablePanel;
    }

    private void populateLoaiSanPhamComboBox() {
        // Lấy danh sách loại sản phẩm từ cơ sở dữ liệu hoặc tạo danh sách giả định
        ArrayList<String> danhSachLoaiSP = getLoaiSanPhamList();

        // Thiết lập mô hình cho JComboBox
        DefaultComboBoxModel<String> cboModel = new DefaultComboBoxModel<>(danhSachLoaiSP.toArray(new String[0]));
        cboLoaiSanPham.setModel(cboModel);
    }

    // Hàm để lấy danh sách loại sản phẩm (giả định)
    private ArrayList<String> getLoaiSanPhamList() {
        // Trong thực tế, bạn sẽ thay thế đoạn này bằng việc truy vấn cơ sở dữ liệu
        // hoặc một cách nào đó để lấy danh sách loại sản phẩm
        ArrayList<String> danhSachLoaiSP = new ArrayList<>();
        danhSachLoaiSP.add("LSP001");
        danhSachLoaiSP.add("LSP002");
        return danhSachLoaiSP;
    }

      private JScrollPane createSanphamPanel(int SoLuongSanPham, String maLoaiSanPham) {
        DefaultTableModel tblModel = (DefaultTableModel) tblFillTable.getModel();
        JPanel productPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        int rowCount = tblModel.getRowCount();
        int productsPerRow = 3;

        // Clear existing content of the panel
        productPanel.removeAll();

        // Khai báo biến index ở đây
        for (int i = 0; i < Math.min(SoLuongSanPham, rowCount); i++) {
            int rowIndex = i;  // Lưu index của hàng hiện tại
            String maLoai = (String) tblModel.getValueAt(rowIndex, 1); // Assuming "MaLoai" is at index 1

            if (maLoai.equals(maLoaiSanPham)) {
                DanhSachSanPham productPanelItem = new DanhSachSanPham(this, rowIndex, tblModel,
                        txtMaSP, txtMaLoai, txtTenSP, txtGia, txtPhanTramGiamGia, lblHinh);

                productPanel.add(productPanelItem);

                // Tăng chỉ số index sau khi thêm sản phẩm
            }
        }

        productPanel.revalidate();
        productPanel.repaint();

        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;
    }

   private JScrollPane createSanphamPanel(int SoLuongSanPham, String maLoaiSanPham, DefaultTableModel tblModel) {
   
        JPanel productPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        int rowCount = tblModel.getRowCount();
        int productsPerRow = 3;

        // Clear existing content of the panel
        productPanel.removeAll();

        // Khai báo biến index ở đây
        for (int i = 0; i < Math.min(SoLuongSanPham, rowCount); i++) {
            int rowIndex = i;  // Lưu index của hàng hiện tại
            String maLoai = (String) tblModel.getValueAt(rowIndex, 1); // Assuming "MaLoai" is at index 1

            if (maLoai.equals(maLoaiSanPham)) {
                DanhSachSanPham productPanelItem = new DanhSachSanPham(this, rowIndex, tblModel,
                        txtMaSP, txtMaLoai, txtTenSP, txtGia, txtPhanTramGiamGia, lblHinh);

                productPanel.add(productPanelItem);

                // Tăng chỉ số index sau khi thêm sản phẩm
            }
        }

        productPanel.revalidate();
        productPanel.repaint();

        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;
    }
   public JLabel getLblHinh() {
        return lblHinh;
    }
     public class DanhSachSanPham extends JPanel {

        private JLabel lblHinh;

        public DanhSachSanPham(SanPhamCodeTay1 mainFrame, int rowIndex, DefaultTableModel tblModel,
                JTextField txtMaSP, JTextField txtMaLoai, JTextField txtTenSP,
                JTextField txtGia, JTextField txtPhanTramGiamGia, JLabel sharedLblHinh) {

            // Assign the shared JLabel
            this.lblHinh = sharedLblHinh;

            setLayout(new BorderLayout());

            // Tạo Border đen cho ProductPanel và đặt kích thước
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            border = BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 55, 10, 0));

            // Đặt Border cho ProductPanel
            setBorder(border);

            String maSP = tblModel.getValueAt(rowIndex, 0).toString();
            SanPham selectedSP = Spdao.selectById(maSP);

            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 0, Integer.MAX_VALUE, 1);
            JSpinner spinnerSoLuong = new JSpinner(spinnerModel);
            // Thay vì tạo mới JTextField, sử dụng txtSoLuong từ SanPhamCodeTay
            JTextField txtSoLuong = mainFrame.txtSoLuong;

            // Thêm các nhãn thông tin
            JPanel infoPanel = new JPanel(new GridLayout(5, 2));  // Thêm một hàng cho chỉ số
            infoPanel.add(new JLabel("Mã SP: " + selectedSP.getMaSP()));
            infoPanel.add(new JLabel("Mã Loại: " + selectedSP.getMaLoai()));
            infoPanel.add(new JLabel("Tên SP: " + selectedSP.getTenSP()));
            infoPanel.add(new JLabel("Giá: " + selectedSP.getGia()));
            infoPanel.add(new JLabel("Phần trăm giảm giá: " + selectedSP.getPhanTramGiamGia()));
            infoPanel.add(new JLabel("Số lượng: "));
            infoPanel.add(spinnerSoLuong);

            // Thêm nút
            JPanel pnlThemGiohang = new JPanel(new FlowLayout());
            JButton btnHoaDon = new JButton("Giỏ hàng");
            Dimension btnSize = new Dimension(90, 40);
            btnHoaDon.setPreferredSize(btnSize);
            pnlThemGiohang.add(btnHoaDon);
            infoPanel.add(pnlThemGiohang);

            // Thêm nhãn hình ảnh
            lblHinh = new JLabel();
            String imagePath = selectedSP.getHinh();
            ImageIcon icon = XImage.read(imagePath);
            if (icon != null) {
                lblHinh.setIcon(icon);
                lblHinh.setToolTipText(imagePath);
            } else {
                lblHinh.setText("Không thể đọc hình ảnh");
            }

            add(lblHinh, BorderLayout.CENTER);
            add(infoPanel, BorderLayout.SOUTH);

            btnHoaDon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Xử lý sự kiện khi nút "Hóa đơn" được nhấn
                    if (selectedSP != null) {
                        txtSoLuong.setText(String.valueOf(spinnerModel.getNumber()));
                        txtMaSP.setText(selectedSP.getMaSP());
                        cboLoaiSanPham.setSelectedItem(selectedSP.getMaLoai());
                        txtTenSP.setText(selectedSP.getTenSP());
                        txtGia.setText(String.valueOf(selectedSP.getGia()));
                        txtPhanTramGiamGia.setText(String.valueOf(selectedSP.getPhanTramGiamGia()));
                        String hinh = selectedSP.getHinh();
                        System.out.println("Hinh:" + hinh);
                        if (hinh != null && !hinh.equals("")) {
                            ImageIcon icon = XImage.read(hinh);
                            if (icon != null) {
                                // Truy cập lblHinh từ createFillTablePanel và cập nhật hình ảnh
                                mainFrame.getLblHinh().setIcon(icon);
                                mainFrame.getLblHinh().setToolTipText(hinh);
                            } else {
                                System.out.println("Không thể đọc hình ảnh");
                            }
                        }

                        ThemHoaDonChiTiet();

                    } else {
                        System.out.println("Không có sản phẩm được chọn.");
                    }
                }

                private void ThemHoaDonChiTiet() {
                    DonHang selectedDonHang = (DonHang) cboDonHang.getSelectedItem();

                    // Check if a DonHang is selected
                    if (selectedDonHang == null) {
                        // Handle the case when no DonHang is selected
                        MsgBox.alert(null, "Vui lòng chọn Đơn Hàng trước khi thêm hóa đơn.");
                        return;
                    }

                    // Get the ChiTietDonHang information from the form
                    ChiTietDonHang ctdh = getFormct();

                    CTdao.insert(ctdh);

                    clearHoaDon();

                    MsgBox.alert(null, "Thêm hóa đơn thành công");
                }

            });
        }
    }
      private void clearHoaDon() {
        // Xóa tất cả các món trong Hóa đơn
        hoaDonPanel.removeAll();
        hoaDonPanel.revalidate();
        hoaDonPanel.repaint();
    }

  private ChiTietDonHang getFormct() {
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
        DonHang selectedDonHang = (DonHang) cboDonHang.getSelectedItem();
        String maDH = selectedDonHang.getMaDH();
        chiTietDonHang.setMaDH(maDH);
        chiTietDonHang.setMaSP(txtMaSP.getText());
        chiTietDonHang.setTenSP(txtTenSP.getText());
        chiTietDonHang.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        chiTietDonHang.setDonGia(Double.parseDouble(txtGia.getText()));
        chiTietDonHang.setGiamGia(Double.parseDouble(txtPhanTramGiamGia.getText()));
        chiTietDonHang.setHinh(lblHinh.getToolTipText());
        return chiTietDonHang;
    }



    public void setProductDetailsInLabels(String maSP, String tenSP, String gia, String phanTramGiamGia, String hinh) {
        // Set thông tin sản phẩm trên các nhãn trong cửa sổ dialog
        lblMaSP.setText(maSP);
        lblTenSP.setText(tenSP);
        lblGia.setText(gia);
        lblPhanTramGiamGia.setText(phanTramGiamGia);
        lblHinh.setToolTipText(hinh);

        // Các nhãn khác có thể được thêm vào tùy theo nhu cầu
    }

    public void selectTab(int index) {
        tabbedPane.setSelectedIndex(index);
    }

    private void fillTable() {
        DefaultTableModel tblmodel = (DefaultTableModel) tblFillTable.getModel();
        tblmodel.setRowCount(0);

        try {
            List<SanPham> list = Spdao.selectAll();

            // Populate the table model
            for (SanPham sp : list) {
                Object[] row = {sp.getMaSP(), sp.getMaLoai(), sp.getTenSP(), sp.getGia(), sp.getPhanTramGiamGia(), sp.getHinh()};
                tblmodel.addRow(row);
            }
            // Refresh tabbedPane with products of type "LSP001"
            refreshTab(tabbedPane.indexOfTab("Sản phẩm LSP001"), Integer.MAX_VALUE, "LSP001", tblmodel);

            // Refresh tabbedPane with products of type "LSP002"
            refreshTab(tabbedPane.indexOfTab("Sản phẩm LSP002"), Integer.MAX_VALUE, "LSP002", tblmodel);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshTab(int tabIndex, int SoLuongSanPham, String maLoaiSanPham, DefaultTableModel tblModel) {
        if (tabIndex >= 0) {
            JScrollPane SanPhamThanhCuon = createSanphamPanel(SoLuongSanPham, maLoaiSanPham, tblModel);
            tabbedPane.setComponentAt(tabIndex, SanPhamThanhCuon);
        }
    }

    private void edit() {
        String maSp = (String) tblFillTable.getValueAt(this.row, 0);
        SanPham nv = Spdao.selectById(maSp);
        this.setForm(nv);
    }

    private void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Chỉnh sửa ảnh trước khi hiển thị
            ImageIcon icon = XImage.read(file.getName());
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            // Hiển thị ảnh
            lblHinh.setIcon(icon);
            lblHinh.setToolTipText(file.getName());
        }
    }

private void setForm(SanPham sp) {
    txtMaSP.setText(sp.getMaSP());
    txtGia.setText(Double.toString(sp.getGia()));
    txtPhanTramGiamGia.setText(Double.toString(sp.getPhanTramGiamGia()));
    
    // Thay thế mã loại sản phẩm từ JTextField sang JComboBox
    cboLoaiSanPham.setSelectedItem(sp.getMaLoai()); // Set giá trị cho JComboBox

    txtTenSP.setText(sp.getTenSP());

    String hinh = sp.getHinh();
    if (hinh != null && !hinh.equals("")) {
        lblHinh.setIcon(XImage.read(hinh));
        lblHinh.setToolTipText(hinh);
    }
}


private SanPham getForm() {
    SanPham sp = new SanPham();
    // Thay thế mã loại sản phẩm từ JTextField sang JComboBox
    sp.setMaLoai((String) cboLoaiSanPham.getSelectedItem()); // Lấy giá trị từ JComboBox

    sp.setMaSP(txtMaSP.getText());
    sp.setGia(Double.parseDouble(txtGia.getText()));
    sp.setPhanTramGiamGia(Double.parseDouble(txtPhanTramGiamGia.getText()));
    sp.setTenSP(txtTenSP.getText());
    sp.setHinh(lblHinh.getToolTipText());
    return sp;
}


// Thêm dữ liệu từ setForm vào bảng fillTable
    private void insert() {
        SanPham cd = getForm();

        try {

            Spdao.insert(cd);

            this.fillTable();
//            VongLapTaoSanPham();
//                this.clearForm();

            MsgBox.alert(this, "Thêm mới thành công");
//            } catch (NumberFormatException e) {
//                MsgBox.alert(this, "Học phí và thời lượng phải là số !");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại");
        }
    }

    private void update() {
        SanPham sp = getForm();
        try {
            Spdao.update(sp);
            MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
        }
    }

// Hàm xóa dữ liệu từ cơ sở dữ liệu
    private void delete() {
        int selectedRow = tblFillTable.getSelectedRow();
        if (selectedRow >= 0) {
            String maSP = tblFillTable.getValueAt(selectedRow, 0).toString();
            try {
                Spdao.delete(maSP);
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        } else {
            MsgBox.alert(this, "Chọn một dòng để xóa");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame parentFrame = new JFrame(); // You may want to customize the parent frame
            boolean modal = true; // Specify whether the frame should be modal or not

            int selectedTabIndex = 0;

            SanPhamCodeTay1 tkwin = new SanPhamCodeTay1(parentFrame, modal);
            tkwin.selectTab(selectedTabIndex);
            tkwin.setVisible(true);
        });
    }

}
