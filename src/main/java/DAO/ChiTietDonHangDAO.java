package DAO;

import Entity.ChiTietDonHang;
import Util.XJdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietDonHangDAO extends qlDAO<ChiTietDonHang, Integer> {

    String INSERT_SQL = "INSERT INTO CHITIETDONHANG (MaDH, MaSP, TenSP, SoLuong, DonGia, GiamGia, hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";    
    String UPDATE_SQL = "UPDATE CHITIETDONHANG SET MaDH=?, MaSP=?, TenSP=?, SoLuong=?, DonGia=?, GiamGia=?, hinh=? WHERE MaChiTietDH=?";
    String DELETE_SQL = "DELETE FROM CHITIETDONHANG WHERE MaChiTietDH=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETDONHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHITIETDONHANG WHERE MaChiTietDH=?";

    @Override
    public void insert(ChiTietDonHang entity) {
    
        XJdbc.update(INSERT_SQL, entity.getMaDH(), entity.getMaSP(), entity.getTenSP(), entity.getSoLuong(), entity.getDonGia(), entity.getGiamGia(), entity.getHinh());
       
    }

    @Override
    public void update(ChiTietDonHang entity) {
     
        XJdbc.update(UPDATE_SQL, entity.getMaDH(), entity.getMaSP(), entity.getTenSP(), entity.getSoLuong(), entity.getDonGia(), entity.getGiamGia(), entity.getHinh(), entity.getMaChiTietDH());
       
    }

    @Override
    public void delete(Integer key) {
       
            XJdbc.update(DELETE_SQL, key);
        
    }

    @Override
    public List<ChiTietDonHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietDonHang selectById(Integer key) {
        List<ChiTietDonHang> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChiTietDonHang> selectBySql(String sql, Object... args) {
        List<ChiTietDonHang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                ChiTietDonHang entity = new ChiTietDonHang();
                entity.setMaChiTietDH(rs.getInt("MaChiTietDH"));
                entity.setMaDH(rs.getString("MaDH"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setDonGia(rs.getFloat("DonGia"));
                entity.setGiamGia(rs.getFloat("GiamGia"));
                entity.setHinh(rs.getString("hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ChiTietDonHang> selectByDonHang(String maDH) {
        String sql = "SELECT * FROM CHITIETDONHANG WHERE MaDH=?";
        return this.selectBySql(sql, maDH);
    }
}
