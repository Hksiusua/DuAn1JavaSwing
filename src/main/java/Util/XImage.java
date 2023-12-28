/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */

  
public class XImage {
    public static Image getAppIcon(){
           String file = "";
           return new ImageIcon(XImage.class.getResource(file)).getImage();
       }

    public static void Save(File src) {
        // Tạo một đối tượng File có tên là src (đại diện cho tệp nguồn cần sao lưu)
        File dst = new File("Icons", src.getName());

        // Kiểm tra xem thư mục cha của tệp đích (dst) có tồn tại hay không
        if (!dst.getParentFile().exists()) {
            // Nếu thư mục cha không tồn tại, tạo thư mục cha và các thư mục con cần thiết
            dst.getParentFile().mkdirs();
        }

        try {
            // Chuyển đổi đường dẫn của tệp nguồn (src) thành đối tượng Path
            Path from = Paths.get(src.getAbsolutePath());

            // Chuyển đổi đường dẫn của tệp đích (dst) thành đối tượng Path
            Path to = Paths.get(dst.getAbsolutePath());

            // Sao chép tệp nguồn (from) đến tệp đích (to), và ghi đè nếu tệp đích đã tồn tại
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra trong quá trình sao chép tệp
            throw new RuntimeException(ex);
        }
    }
    // Phương thức này đọc một file ảnh từ thư mục logos và trả về một đối tượng ImageIcon
       public static ImageIcon read(String fileName){
        // Tạo một đối tượng File với đường dẫn là logos/fileName
        File path = new File("Icons", fileName);
        // Trả về một đối tượng ImageIcon với đường dẫn tuyệt đối của file ảnh
        return new ImageIcon(path.getAbsolutePath());
    }

}

    

