/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author adm
 */
public class SanPham {

    
private String MaSP;
private String MaLoai;
private String TenSP;
private double Gia;
private int soLuong;

private double PhanTramGiamGia;
private String Hinh;

    public SanPham() {
    }

    public SanPham(String MaSP, String MaLoai, String TenSP, double Gia, double PhanTramGiamGia, String Hinh) {
        this.MaSP = MaSP;
        this.MaLoai = MaLoai;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.PhanTramGiamGia = PhanTramGiamGia;
        this.Hinh = Hinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

 

    

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    

 
    public double getPhanTramGiamGia() {
        return PhanTramGiamGia;
    }

    public void setPhanTramGiamGia(double PhanTramGiamGia) {
        this.PhanTramGiamGia = PhanTramGiamGia;
    }


    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
    

}
