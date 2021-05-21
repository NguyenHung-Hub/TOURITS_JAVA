package dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import connect.ConnectDB;
import entity.ChuyenDi;

public class ChuyenDi_Dao_impl implements ChuyenDi_DAO {

	@Override
	public ArrayList<ChuyenDi> getAllChuyenDi() {
		ArrayList<ChuyenDi> dsChuyenDi = new ArrayList<ChuyenDi>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		String sql = "select * from ChuyenDi";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maChuyenDi = rs.getString(1);
				String tenChuyenDi = rs.getString(2);
				Date ngayKhoiHanh = rs.getDate(3);
				Date ngayKetThuc = rs.getDate(4);
				byte[] img = rs.getBytes(5);
				ImageIcon icon = new ImageIcon(img);
				Image anh = icon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
				ChuyenDi chuyenDi = new ChuyenDi(maChuyenDi, tenChuyenDi, ngayKhoiHanh, ngayKetThuc, anh);
				dsChuyenDi.add(chuyenDi);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsChuyenDi;
	}

	@Override
	public ChuyenDi getChuyenDi(String maCD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ChuyenDi chuyenDi = null;
		String sql = "select * from ChuyenDi where maChuyenDi = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maCD);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maChuyenDi = rs.getString(1);
				String tenChuyenDi = rs.getString(2);
				Date ngayKhoiHanh = rs.getDate(3);
				Date ngayKetThuc = rs.getDate(4);
				byte[] img = rs.getBytes(5);
				ImageIcon icon = new ImageIcon(img);
				Image anh = icon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
				chuyenDi = new ChuyenDi(maChuyenDi, tenChuyenDi, ngayKhoiHanh, ngayKetThuc, anh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return chuyenDi;
	}

	@Override
	public boolean insertChuyenDi(ChuyenDi chuyenDi) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateChuyenDi(ChuyenDi chuyenDi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChuyenDi(ChuyenDi chuyenDi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ChuyenDi> themVaoBangChuyenDi() {
		return null;
	}

	@Override
	public ArrayList<ChuyenDi> themVaoBangChuyenDi(int page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
