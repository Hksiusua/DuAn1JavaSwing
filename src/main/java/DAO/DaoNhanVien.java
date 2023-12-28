package DAO;

import Entity.NhanVien1;
import Util.XJdbc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoNhanVien extends qlDAO<NhanVien1, String> {

@Override
    public void insert(NhanVien1 entity) {
        // Thêm vào cơ sở dữ liệu với mật khẩu chuỗi gốc
        String sql = "INSERT INTO NHANVIEN (MaNV, HoVaTenLot, Ten, MatKhau, SoDT, Email, DiaChi, NgaySinh, TrangThaiLamViec, GioiTinh, VaiTro, Hinh) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        XJdbc.update(sql,
                entity.getMaNV(), entity.getHoVaTenLot(), entity.getTen(), entity.getMatKhau(),
                entity.getSoDT(), entity.getEmail(), entity.getDiaChi(), entity.getNgaySinh(),
                entity.isTrangThaiLamViec(), entity.getGioiTinh(), entity.isVaiTro(), entity.getHinh());
    }

    @Override
    public void update(NhanVien1 entity) {
        // Cập nhật cơ sở dữ liệu với mật khẩu chuỗi gốc
        String sql = "UPDATE NHANVIEN SET HoVaTenLot = ?, Ten = ?, MatKhau = ?, SoDT = ?, " +
                "Email = ?, DiaChi = ?, NgaySinh = ?, TrangThaiLamViec = ?, GioiTinh = ?, VaiTro = ?, Hinh = ? " +
                "WHERE MaNV = ?";
        XJdbc.update(sql, entity.getHoVaTenLot(), entity.getTen(), entity.getMatKhau(),
                entity.getSoDT(), entity.getEmail(), entity.getDiaChi(),
                entity.getNgaySinh(), entity.isTrangThaiLamViec(), entity.getGioiTinh(),
                entity.isVaiTro(), entity.getHinh(), entity.getMaNV());
    }
    

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NHANVIEN WHERE MaNV = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public NhanVien1 selectById(String id) {
        String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MaNV=?";
        List<NhanVien1> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien1> selectAll() {
        String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NhanVien1> selectBySql(String sql, Object... args) {
        List<NhanVien1> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                NhanVien1 entity = new NhanVien1();         
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoVaTenLot(rs.getString("HoVaTenLot"));
                entity.setTen(rs.getString("Ten"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setSoDT(rs.getString("SoDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setTrangThaiLamViec(rs.getBoolean("TrangThaiLamViec"));
                entity.setGioiTinh(rs.getString("GioiTinh"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setHinh(rs.getString("Hinh"));
                 entity.setSTT(rs.getInt("STT"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien1> searchByKeyword(String keyword) {
        String SEARCH_BY_KEYWORD_SQL = "SELECT * FROM NHANVIEN WHERE MaNV LIKE ? OR HoVaTenLot LIKE ? OR Ten LIKE ? OR Email LIKE ? OR DiaChi LIKE ?";
        keyword = "%" + keyword + "%";
        return this.selectBySql(SEARCH_BY_KEYWORD_SQL, keyword, keyword, keyword, keyword, keyword);
    }

}
