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
import entity.DiaChi;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from TaiKhoan as tk\r\n"
					+ "join KhachHang as kh on tk.soDienThoai = kh.soDienThoai\r\n"
					+ "join DiaChi as dc on kh.maDiaChi = dc.maDiaChi";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				KhachHang khachHang = new KhachHang();
				khachHang.setMaKhachHang(rs.getString("maKhachHang"));
				khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
				khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
				khachHang.setNgaySinh(rs.getDate("ngaySinh"));
				khachHang.setDiaChi(new DiaChi(rs.getString("maDiaChi"), rs.getString("tinhThanh"), rs.getString("quanHuyen"), rs.getString("phuongXa")));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setMatKhau(rs.getString("matKhau"));
				dsKhachHang.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	public String phatSinhMaKhachHang() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select max(maKhachHang) from KhachHang";
		String ID = "";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(1).substring(0, 2));
//				System.out.println(rs.getString(1).substring(2, 6));
				ID = PhatSinhMaTuDong.getMa(rs.getString(1).substring(0, 2), rs.getString(1).substring(2, 7), 5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ID;
	}

	public boolean insertKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert TaiKhoan\r\n"
				+ "values (N'"+ khachHang.getSoDienThoai() +"', N'"+ khachHang.getEmail() +"', N'"+ khachHang.getMatKhau() +"')\r\n"
				+ "insert KhachHang\r\n"
				+ "values (N'"+ phatSinhMaKhachHang() +"', N'"+ khachHang.getTenKhachHang() +"', N'"+ khachHang.isGioiTinh() +"', N'"+ khachHang.getNgaySinh() +"', N'"+ khachHang.getDiaChi().getMaDiaChi() +"', N'"+ khachHang.getSoDienThoai() +"')";
		try {
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public void updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<KhachHang> themVaoBang(int page, String maKH, String tenKH, String gT) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int number = page * 20;
		
		String sql = "select * from TaiKhoan as tk\r\n"
				+ "join KhachHang as kh on tk.soDienThoai = kh.soDienThoai\r\n"
				+ "join DiaChi as dc on kh.maDiaChi = dc.maDiaChi\r\n"
				+ "where maKhachHang like N'%"+ maKH +"%'\r\n"
				+ "and (tenKhachHang like N'%"+ tenKH +"%' or dbo.ufn_removeMark(tenKhachHang) like N'%"+ tenKH +"%')\r\n"
				+ "and gioiTinh like '%"+ gT+"%'\r\n"
				+ "order by maKhachHang offset "+ number +" rows fetch next 20 rows only";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null) {
				return null;
			}
			while (rs.next()) {
				KhachHang khachHang = new KhachHang();
				khachHang.setMaKhachHang(rs.getString("maKhachHang"));
				khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
				khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
				khachHang.setNgaySinh(rs.getDate("ngaySinh"));
				khachHang.setDiaChi(new DiaChi(rs.getString("maDiaChi"), rs.getString("tinhThanh"), rs.getString("quanHuyen"), rs.getString("phuongXa")));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setMatKhau(rs.getString("matKhau"));
				dsKhachHang.add(khachHang);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public ArrayList<KhachHang> themVaoBang(int page) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int number = page * 20;
		
		String sql = "select * from TaiKhoan as tk\r\n"
				+ "join KhachHang as kh on tk.soDienThoai = kh.soDienThoai\r\n"
				+ "join DiaChi as dc on kh.maDiaChi = dc.maDiaChi\r\n"
				+ "order by maKhachHang offset 0 rows fetch next 20 rows only";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs == null)
				return null;
			while (rs.next()) {
				KhachHang khachHang = new KhachHang();
				khachHang.setMaKhachHang(rs.getString("maKhachHang"));
				khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
				khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
				khachHang.setNgaySinh(rs.getDate("ngaySinh"));
				khachHang.setDiaChi(new DiaChi(rs.getString("maDiaChi"), rs.getString("tinhThanh"), rs.getString("quanHuyen"), rs.getString("phuongXa")));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));
				khachHang.setEmail(rs.getString("email"));
				khachHang.setMatKhau(rs.getString("matKhau"));
				dsKhachHang.add(khachHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsKhachHang;
	}

	public int tongKhachHang(String maKH, String tenKH, String gT) {
		int count = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select count(*) from TaiKhoan as tk\r\n"
				+ "join KhachHang as kh on tk.soDienThoai = kh.soDienThoai\r\n"
				+ "join DiaChi as dc on kh.maDiaChi = dc.maDiaChi";
		
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
}
