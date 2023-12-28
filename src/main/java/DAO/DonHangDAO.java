package DAO;


import Entity.DonHang;
import Util.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonHangDAO extends qlDAO<DonHang, String> {

    String INSERT_SQL = "INSERT into DONHANG (MaDH, NgayDat, HinhThucThanhToan, MaNV) VALUES(?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE DONHANG set NgayDat=?, HinhThucThanhToan=?, MaNV=? WHERE MaDH=?";
    String DELETE_SQL = "DELETE FROM DONHANG WHERE MaDH=?";
    String SELECT_ALL_SQL = "SELECT * FROM DONHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM DONHANG WHERE MaDH=?";

    @Override
    public void insert(DonHang entity) {
        XJdbc.update(INSERT_SQL, entity.getMaDH(), entity.getNgayDat(), entity.getHinhThucThanhToan(), entity.getMaNV());
    }

    @Override
    public void update(DonHang entity) {
        XJdbc.update(UPDATE_SQL, entity.getNgayDat(), entity.getHinhThucThanhToan(), entity.getMaNV(), entity.getMaDH());
    }

    @Override
    public void delete(String key) {
        XJdbc.update(DELETE_SQL, key);
    }

    @Override
    public List<DonHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }
 
    @Override
    public DonHang selectById(String key) {
        List<DonHang> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                DonHang entity = new DonHang();
                entity.setMaDH(rs.getString("MaDH"));
                entity.setNgayDat(rs.getDate("NgayDat"));
                entity.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                entity.setMaNV(rs.getString("MaNV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
