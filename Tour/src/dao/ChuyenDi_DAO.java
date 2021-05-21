package dao;

import java.util.ArrayList;

import entity.ChuyenDi;

public interface ChuyenDi_DAO {
	public ArrayList<ChuyenDi> getAllChuyenDi();
	public ChuyenDi getChuyenDi(String maCD);
	public boolean insertChuyenDi(ChuyenDi chuyenDi);
	public void updateChuyenDi(ChuyenDi chuyenDi);
	public void deleteChuyenDi(ChuyenDi chuyenDi);
	public ArrayList<ChuyenDi> themVaoBangChuyenDi();
	public ArrayList<ChuyenDi> themVaoBangChuyenDi(int page);
}
