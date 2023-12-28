package Entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Tongchitiet {
     private int tongSoLuong;
    private int tongDonGia;
    private int tongGiamGia;
    private int tongThanhTien;

    public Tongchitiet(int tongSoLuong, int tongDonGia, int tongGiamGia, int tongThanhTien) {
        this.tongSoLuong = tongSoLuong;
        this.tongDonGia = tongDonGia;
        this.tongGiamGia = tongGiamGia;
        this.tongThanhTien = tongThanhTien;
    }

    public Tongchitiet() {
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public int getTongDonGia() {
        return tongDonGia;
    }

    public void setTongDonGia(int tongDonGia) {
        this.tongDonGia = tongDonGia;
    }

    public int getTongGiamGia() {
        return tongGiamGia;
    }

    public void setTongGiamGia(int tongGiamGia) {
        this.tongGiamGia = tongGiamGia;
    }

    public int getTongThanhTien() {
        return tongThanhTien;
    }

    public void setTongThanhTien(int tongThanhTien) {
        this.tongThanhTien = tongThanhTien;
    }
    
}
