/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Util.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author adm
 */
public class ThongKeDAO {
     public List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
    try {
        List<Object[]> list = new ArrayList<>();
        ResultSet rs = XJdbc.query(sql, args);
        while (rs.next()) {
            Object[] vals = new Object[cols.length];
            for (int i = 0; i < cols.length; i++) {
                vals[i] = rs.getObject(cols[i]);
            }
            list.add(vals);
        }
        rs.getStatement().getConnection().close();
        return list;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    public List<Object[]> getSanPhamBanChayNhat() {
    String sql = "{CALL SanPhamBanChayNhat}";

    String[] cols = {"MaSP", "TenSP", "Gia", "SoLuongBanDuoc"};

    return this.getListOfArray(sql, cols);
}

  public List<Object[]> getSAnPhamBanChamNhat() {
    String sql = "{CALL SanPhamBanChamNhat}";

    String[] cols = {"MaSP", "TenSP", "Gia", "SoLuongBanDuoc"};

    return this.getListOfArray(sql, cols);
}
  public List<Object[]> getThongKeDoanhThu(Date ngayBatDau, Date ngayKetThuc) {
    String sql = "{CALL DoanhThu(?, ?)}";
    String[] cols = {"MaDH", "NgayDat", "TongDoanhThu"};
    return this.getListOfArray(sql, cols, ngayBatDau, ngayKetThuc);
}
  public List<Object[]> getThongKeDoanhThuTheoNam(int nam) {
    String sql = "{CALL DoanhThuTheoNam(?)}";
    String[] cols = {"MaDH", "ThangDat", "TongDoanhThu"};
    return this.getListOfArray(sql, cols, nam);
}
   
}
