
package DAO;

import Entity.LoaiSanPham;
import Entity.SanPham;
import Util.XJdbc;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author adm
 */
public class LoaiSanPhamDAO extends qlDAO<LoaiSanPham, String>{

String INSERT_SQL="INSERT into LOAISANPHAM (MaLoai,TenLoai) VALUES(?,?)";
String UPDATE_SQL="UPDATE LOAISANPHAM set TenLoai=? WHERE MaLoai=?";
String DELETE_SQL="DELETE FROM LOAISANPHAM WHERE MaLoai=?" ;
String SELECT_ALL_SQL="SELECT * FROM LOAISANPHAM";
String SELECT_BY_ID_SQL="SELECT * FROM LOAISANPHAM WHERE MaLoai=?";
    @Override
    public void insert(LoaiSanPham entity) {
        XJdbc.update(INSERT_SQL, entity.getTenLoai(),entity.getMaLoai());

    }

    @Override
    public void update(LoaiSanPham entity) {
        XJdbc.update(UPDATE_SQL, entity.getTenLoai(),entity.getMaLoai());

    }
    
    

    @Override
    public void delete(String key) {
        XJdbc.update(DELETE_SQL, key);

    }

    @Override
    public List<LoaiSanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL );
    }

    @Override
    public LoaiSanPham selectById(String key) {
     List<LoaiSanPham> list=this.selectBySql(SELECT_BY_ID_SQL, key);
    if(list.isEmpty()){
    return null;
    }
    return list.get(0);
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
          List<LoaiSanPham>list=new ArrayList<LoaiSanPham>();
        try {
            ResultSet rs=XJdbc.query(sql, args);
            while(rs.next()){
            LoaiSanPham entity=new LoaiSanPham();
            entity.setMaLoai(rs.getString("MaLoai"));
            entity.setTenLoai(rs.getString("TenLoai"));
            list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<LoaiSanPham> selectAllCategories() {
    String sql = "SELECT * FROM LOAISANPHAM";
    return this.selectBySql(sql);
}
public LoaiSanPham selectByName(String categoryName) {
    String sql = "SELECT * FROM LOAISANPHAM WHERE TenLoai=?";
    List<LoaiSanPham> list = this.selectBySql(sql, categoryName);
    if (list.isEmpty()) {
        return null;
    }
    return list.get(0);
}


}
