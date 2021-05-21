package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO_impl implements KhachHang_DAO {
	@Override
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from KhachHang";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				KhachHang khachHang = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, email, diaChi);
				dsKhachHang.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	@Override
	public KhachHang getKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		KhachHang khachHang = null;
		String sql = "select * from KhachHang where maKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKhachHang);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				khachHang = new KhachHang(maKH, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, email, diaChi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHang;
	}

	@Override
	public boolean insertKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<KhachHang> themVaoBang(int page, String maKH, String tenKH, String gT) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int number = page * 20;
		
		String sql = "select * from KhachHang\r\n"
				+ "where maKhachHang like N'%"+ maKH +"%' and (tenKhachHang like N'%"+ tenKH +"%' "
						+ "or dbo.ufn_removeMark(tenKhachHang) like N'%"+ tenKH +"%') "
								+ "and gioiTinh like '%"+ gT +"%'\r\n"
				+ "order by maKhachHang offset "+ number +" row fetch next 20 row only";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null) {
				return null;
			}
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				KhachHang khachHang = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, email, diaChi);
				dsKhachHang.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	@Override
	public ArrayList<KhachHang> themVaoBang(int page) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int number = page * 20;
		
		String sql = "select * from KhachHang"
				+ " order by maKhachHang offset " + number + " row fetch next 20 rows only";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null)
				return null;
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
				String diaChi = rs.getString(7);
				KhachHang khachHang = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, ngaySinh, soDienThoai, email, diaChi);
				dsKhachHang.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsKhachHang;
	}

	@Override
	public int tongKhachHang(String maKH, String tenKH, String gT) {
		int count = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select COUNT(*) from KhachHang\r\n"
				+ "where maKhachHang like N'%"+ maKH +"%' and (tenKhachHang like N'%"+ tenKH +"%' "
						+ "or dbo.ufn_removeMark(tenKhachHang) like N'%"+ tenKH +"%') "
								+ "and gioiTinh like '%"+ gT +"%'";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ArrayList<String> getAllTinh() {
		ArrayList<String> dsTinh = new ArrayList<String>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select distinct diaChi from KhachHang";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String diaChi = rs.getString(1);
				if(!(diaChi == null))
					dsTinh.add(diaChi);
				else
					dsTinh.add("Trống");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTinh;
	}
}
