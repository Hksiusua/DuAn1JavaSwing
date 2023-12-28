/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author adm
 */
public class DonHang {
    private String MaDH;
    private Date NgayDat;
    private String HinhThucThanhToan;
    private String MaNV;

    public DonHang() {
    }

    public DonHang(String MaDH, Date NgayDat, String HinhThucThanhToan, String MaNV) {
        this.MaDH = MaDH;
        this.NgayDat = NgayDat;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.MaNV = MaNV;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

 	@Override
public String toString() {
    return MaDH; // "tenChuyenDe" là thuộc tính chứa tên của chuyên đề
}

    
    

}
