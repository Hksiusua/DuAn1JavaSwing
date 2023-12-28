/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Newform;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.jsoup.nodes.Document;

import Entity.ChiTietDonHang;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.util.HashMap;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author adm
 */
public class HoaDonJDialog extends javax.swing.JDialog {

  private double tongThanhTien=0;
  private  int tongSoLuong;
  private  Map<String, Double> tongSanPhamTheoLoai ;
   
    public HoaDonJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public double getTongThanhTien() {
        return tongThanhTien;
    }
public double displayChiTietDonHangData(List<ChiTietDonHang> chiTietDonHangList) {
    StringBuilder sb = new StringBuilder();

     tongThanhTien = 0;
     tongSoLuong = 0;
    tongSanPhamTheoLoai = new HashMap<>();

    // Sắp xếp các thông tin nằm ngang
    sb.append("<html><body><table border='1'>");

    // Tiêu đề của bảng
    sb.append("<tr><th>Mã chi tiết đơn hàng</th><th>Mã đơn hàng</th><th>Mã sản phẩm</th>")
      .append("<th>Tên sản phẩm</th><th>Số lượng</th><th>Đơn giá</th><th>Giảm giá</th><th>Thành tiền</th></tr>");

    for (ChiTietDonHang ctdh : chiTietDonHangList) {
        double thanhTien = ctdh.getSoLuong() * ctdh.getDonGia() * (1 - ctdh.getGiamGia() / 100);

        // Thêm một hàng cho mỗi ChiTietDonHang
        sb.append("<tr>")
          .append("<td>").append(ctdh.getMaChiTietDH()).append("</td>")
          .append("<td>").append(ctdh.getMaDH()).append("</td>")
          .append("<td>").append(ctdh.getMaSP()).append("</td>")
          .append("<td>").append(ctdh.getTenSP()).append("</td>")
          .append("<td>").append(ctdh.getSoLuong()).append("</td>")
          .append("<td>").append(ctdh.getDonGia()).append("</td>")
          .append("<td>").append(ctdh.getGiamGia()).append("</td>")
          .append("<td>").append(thanhTien).append("</td>")
          .append("</tr>");

        // Tính toán tổng thành tiền và tổng số lượng
        tongThanhTien += thanhTien;
        tongSoLuong += ctdh.getSoLuong();

        // Tính toán tổng sản phẩm theo loại
        String maSP = ctdh.getMaSP();
        if (tongSanPhamTheoLoai.containsKey(maSP)) {
            double tongGiaSanPham = tongSanPhamTheoLoai.get(maSP);
            tongSanPhamTheoLoai.put(maSP, tongGiaSanPham + thanhTien);
        } else {
            tongSanPhamTheoLoai.put(maSP, thanhTien);
        }
    }
// this.tongThanhTien = tongThanhTien;
    // Đóng bảng HTML
//     sb.append("</table></body></html>");

    // Hiển thị tổng thành tiền và tổng số lượng
    sb.append("<html><strong>Tổng thành tiền:</strong> ").append(tongThanhTien).append("<br></html>");

    sb.append("Tổng số lượng: ").append(tongSoLuong).append("<br>");

    // Hiển thị tổng sản phẩm theo loại
    sb.append("Tổng sản phẩm theo loại:<br>");
    for (Map.Entry<String, Double> entry : tongSanPhamTheoLoai.entrySet()) {
        sb.append("Mã sản phẩm: ").append(entry.getKey()).append(", Tổng giá: ").append(entry.getValue()).append("<br>");
    }

    // Thêm thông tin thời gian xuất hóa đơn
    Date currentTime = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String formattedTime = dateFormat.format(currentTime);
    sb.append("Thời gian: ").append(formattedTime).append("<br>");

    // Hiển thị chuỗi HTML trong jTextPane1
    jTextPane1.setContentType("text/html");
    jTextPane1.setText(sb.toString());
    return tongThanhTien;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnXuatFilePDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnTaoMa = new javax.swing.JButton();
        btnXuatFileEXCEL = new javax.swing.JButton();
        labelQRCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(128, 188, 179));

        btnXuatFilePDF.setBackground(new java.awt.Color(255, 255, 204));
        btnXuatFilePDF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatFilePDF.setText("Xuất file PDF");
        btnXuatFilePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFilePDFActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));

        jTextPane1.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setViewportView(jTextPane1);

        btnTaoMa.setBackground(new java.awt.Color(255, 255, 204));
        btnTaoMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoMa.setText("Tạo mã");
        btnTaoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaActionPerformed(evt);
            }
        });

        btnXuatFileEXCEL.setBackground(new java.awt.Color(255, 255, 204));
        btnXuatFileEXCEL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatFileEXCEL.setText("Xuất EXCEL");
        btnXuatFileEXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileEXCELActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnTaoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnXuatFileEXCEL)
                .addGap(16, 16, 16)
                .addComponent(btnXuatFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatFileEXCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
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

    private void btnXuatFilePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFilePDFActionPerformed
        try {
               
            jTextPane1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(HoaDonJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatFilePDFActionPerformed

private static String updateQRValue(double tongThanhTien) {
    // Create the QR code link with the total amount=
    String qrCodeLink = "https://api.vietqr.io/image/970405-4814205347370-AjzEsS9.jpg?accountName=TRAN%20CONG%20NGHIA&amount="+tongThanhTien;
    return qrCodeLink;
}


    private void btnTaoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaActionPerformed

     double tongThanhTien = getTongThanhTien();

    // Create the QR code link with the total amount
    String updatedQRCode = updateQRValue(tongThanhTien);

    try {
        // Read the image from the updated QR code URL
        BufferedImage image = ImageIO.read(new URL(updatedQRCode));

        if (image != null) {
            // Display the image and scale it
            int w = 300;
            int h = 300;
            Image img = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
            labelQRCode.setIcon(new ImageIcon(img));

            // Optionally, show a message or perform other actions
            // JOptionPane.showMessageDialog(this, "QR Code generated and displayed.");
        } else {
            // Handle the case where the image is not loaded
            JOptionPane.showMessageDialog(this, "Failed to generate or load QR Code.");
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        // Handle the case where an exception occurs while loading the image
        JOptionPane.showMessageDialog(this, "Error loading QR Code: " + ex.getMessage());
    }



    }//GEN-LAST:event_btnTaoMaActionPerformed

    private void btnXuatFileEXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileEXCELActionPerformed
        xuấtFileExcel();
       
    }//GEN-LAST:event_btnXuatFileEXCELActionPerformed
private void xuấtFileExcel() {
    try {
        // Lấy dữ liệu từ jTextPane1
        String htmlContent = jTextPane1.getText();

        // Loại bỏ các thẻ HTML từ nội dung
        String plainTextContent = stripHtmlTags(htmlContent);

        // Tạo một Workbook mới (XSSFWorkbook cho định dạng .xlsx)
        Workbook workbook = new XSSFWorkbook();

        // Tạo một trang (sheet) mới
        Sheet sheet = workbook.createSheet("Dữ liệu");

        // Tạo một dòng (row) mới
        Row row = sheet.createRow(0);

        // Tạo các ô (cell) và thiết lập giá trị từ plainTextContent
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Tổng thành tiền: " + tongThanhTien);

        // Di chuyển đến dòng tiếp theo
        row = sheet.createRow(1);

        Cell cell2 = row.createCell(0);
        cell2.setCellValue("Tổng số lượng: " + tongSoLuong);

        // Di chuyển đến dòng tiếp theo
        row = sheet.createRow(2);

        Cell cell3 = row.createCell(0);
        cell3.setCellValue("Tổng sản phẩm theo loại:");

        // Di chuyển đến dòng tiếp theo
        int rowNum = 3;
        for (Map.Entry<String, Double> entry : tongSanPhamTheoLoai.entrySet()) {
            row = sheet.createRow(rowNum);
            Cell cellMaSP = row.createCell(0);
            Cell cellTongGia = row.createCell(1);

            cellMaSP.setCellValue("Mã sản phẩm: " + entry.getKey());
            cellTongGia.setCellValue("Tổng giá: " + entry.getValue());

            rowNum++;
        }

        // Mở OutputStream để ghi vào file
        try (FileOutputStream fileOut = new FileOutputStream("D:\\Dulieu1.xlsx")) {
            // Ghi Workbook vào OutputStream
            workbook.write(fileOut);
        }

        // Đóng Workbook sau khi ghi xong
        workbook.close();

        // Thông báo khi xuất file thành công
        JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
    } catch (Exception ex) {
        ex.printStackTrace();
        // Hiển thị thông báo lỗi khi có vấn đề trong quá trình xuất file
        JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
private String stripHtmlTags(String html) {
    // Sử dụng Jsoup để loại bỏ các thẻ HTML
    Document document = (Document) Jsoup.parse(html);
    return Jsoup.clean(document.html(), Whitelist.none());
}   

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
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HoaDonJDialog dialog = new HoaDonJDialog(new javax.swing.JFrame(), true);
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
//    // Đoạn mã QR của bạn
//    String qrCode = "00020101021238570010A00000072701270006970405011348142150212460208QRIBFTTA530370454" + giaMoi + "5802VN6304E508";
//     String qrCode1 ="00020101021238570010A00000072701270006970405011348142053473700208QRIBFTTA530370454"+ giaMoi +"5802VN630410A1";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoMa;
    private javax.swing.JButton btnXuatFileEXCEL;
    private javax.swing.JButton btnXuatFilePDF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelQRCode;
    // End of variables declaration//GEN-END:variables
}
