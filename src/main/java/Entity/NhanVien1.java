package Entity;

import java.util.Date;

public class NhanVien1 {
    private int STT;
    private String maNV;
    private String hoVaTenLot;
    private String ten;
    private String matKhau;
    private String soDT;
    private String email;
    private String diaChi;
    private Date ngaySinh;
    private boolean trangThaiLamViec;
    private String gioiTinh;
    private boolean vaiTro;
    private String hinh;

    public NhanVien1() {
    }

    public NhanVien1(int STT, String maNV, String hoVaTenLot, String ten, String matKhau, String soDT, String email, String diaChi, Date ngaySinh, boolean trangThaiLamViec, String gioiTinh, boolean vaiTro, String hinh) {
        this.STT = STT;
        this.maNV = maNV;
        this.hoVaTenLot = hoVaTenLot;
        this.ten = ten;
        this.matKhau = matKhau;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.trangThaiLamViec = trangThaiLamViec;
        this.gioiTinh = gioiTinh;
        this.vaiTro = vaiTro;
        this.hinh = hinh;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoVaTenLot() {
        return hoVaTenLot;
    }

    public void setHoVaTenLot(String hoVaTenLot) {
        this.hoVaTenLot = hoVaTenLot;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isTrangThaiLamViec() {
        return trangThaiLamViec;
    }

    public void setTrangThaiLamViec(boolean trangThaiLamViec) {
        this.trangThaiLamViec = trangThaiLamViec;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

   
 
}
