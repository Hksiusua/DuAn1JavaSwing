/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author adm
 */
public class ChiTietDonHang {
    private int MaChiTietDH;
    private String MaDH;
    private String MaSP;
    private String TenSP;
    private int SoLuong;
    private double DonGia;
    private double GiamGia;
    private String Hinh;

    public ChiTietDonHang(int MaChiTietDH, String MaDH, String MaSP, String TenSP, int SoLuong, double DonGia, double GiamGia) {
        this.MaChiTietDH = MaChiTietDH;
        this.MaDH = MaDH;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
    }

    public ChiTietDonHang(int MaChiTietDH, String MaDH, String MaSP, String TenSP, int SoLuong, double DonGia, double GiamGia, String Hinh) {
        this.MaChiTietDH = MaChiTietDH;
        this.MaDH = MaDH;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
        this.Hinh = Hinh;
    }

   
    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int MaChiTietDH, String MaDH, String MaSP, String TenSP, int SoLuong) {
        this.MaChiTietDH = MaChiTietDH;
        this.MaDH = MaDH;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
    }




    public int getMaChiTietDH() {
        return MaChiTietDH;
    }

    public void setMaChiTietDH(int MaChiTietDH) {
        this.MaChiTietDH = MaChiTietDH;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

   
    
}
