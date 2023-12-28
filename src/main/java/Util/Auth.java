    package Util;

import Entity.DonHang;
import Entity.NhanVien1;

public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien1 user = null;
        public static DonHang donHang = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.user = null;
    }
    /**
     * Kiểm tra xem đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return Auth.user != null;
    }
     /**
     * Kiểm tra xem có phải là trưởng phòng hay không
     */
    public static boolean isManager() {
        return Auth.isLogin() && user.isVaiTro();
    }
     private static NhanVien1 loggedInNhanVien;

    // Phương thức để lấy thông tin của nhân viên đăng nhập
    public static NhanVien1 getLoggedInNhanVien() {
        return loggedInNhanVien;
    }

    // Phương thức để thiết lập thông tin của nhân viên đăng nhập
    public static void setLoggedInNhanVien(NhanVien1 nhanVien) {
        loggedInNhanVien = nhanVien;
    }
@Override
public String toString() {
    if (user != null) {
        return "Nhân viên: " + user.getMaNV(); // Sử dụng thông tin người dùng từ biến user
    } else {
        return "Người dùng chưa đăng nhập";
    }
}

  
}
