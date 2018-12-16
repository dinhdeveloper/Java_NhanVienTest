package DAO;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinh
 */
public class NhanVienDao {
    public static List<NhanVien> getData(){
        List<NhanVien> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Connected.ConnectSQL());
                PreparedStatement stmt = conn.prepareCall("{call getDataAccount}");
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("AccId"));
                nv.setHoTen(rs.getString("AccFullName"));
                nv.setNgaySinh(rs.getDate("AccBirthDay"));
//                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                nv.setGioiTinh(rs.getBoolean("AccGender"));
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
