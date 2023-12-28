/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SanPham;
import Util.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoSanPham extends qlDAO<SanPham, String> {

   String INSERT_SQL = "INSERT into SANPHAM (MaSP,MaLoai,TenSP,Gia,PhanTramGiamGia,Hinh) VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SANPHAM set MaLoai=?,TenSP=?,Gia=?,PhanTramGiamGia=?,Hinh=? WHERE MaSP=?";
    String DELETE_SQL = "DELETE FROM SANPHAM WHERE MaSP=?";
    String SELECT_ALL_SQL = "SELECT * FROM SANPHAM";
    String SELECT_BY_ID_SQL = "SELECT * FROM SANPHAM WHERE MaSP=?";

    @Override
    public void insert(SanPham entity) {
        XJdbc.update(INSERT_SQL, entity.getMaSP(), entity.getMaLoai(), entity.getTenSP(), entity.getGia(), entity.getPhanTramGiamGia(), entity.getHinh());

    }

    @Override
    public void update(SanPham entity) {
        XJdbc.update(UPDATE_SQL, entity.getMaLoai(), entity.getTenSP(), entity.getGia(), entity.getPhanTramGiamGia(), entity.getHinh(), entity.getMaSP());

    }

    @Override
    public void delete(String key) {
        XJdbc.update(DELETE_SQL, key);

    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }
    
   

    @Override
    public SanPham selectById(String key) {
        List<SanPham> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<SanPham>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setMaLoai(rs.getString("MaLoai"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setGia(rs.getFloat("Gia"));
                entity.setPhanTramGiamGia(rs.getFloat("PhanTramGiamGia"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<SanPham> selectByMaML(String maLoai) {
    String sql = "SELECT * FROM SANPHAM WHERE MaLoai=?";
    return this.selectBySql(sql, maLoai);
}
    public int countAllProducts() {
    String countQuery = "SELECT COUNT(*) FROM SANPHAM";
    
    return 0; // Trả về 0 nếu có lỗi
}


}


