package dao;

import java.util.ArrayList;

import entity.KhachHang;

public interface KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang();
	public KhachHang getKhachHang(String maKhachHang);
	public boolean insertKhachHang(KhachHang khachHang);
	public void updateKhachHang(KhachHang khachHang);
	public void deleteKhachHang(KhachHang khachHang);
	public ArrayList<KhachHang> themVaoBang(int page, String maKH, String tenKH, String gT);
	public ArrayList<KhachHang> themVaoBang(int page);
	public int tongKhachHang(String maKH, String tenKH, String gT);
	public ArrayList<String> getAllTinh();
}
