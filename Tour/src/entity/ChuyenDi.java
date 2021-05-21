package entity;

import java.awt.Image;
import java.sql.Date;

public class ChuyenDi {
	private String maChuyenDi;
	private String tenChuyenDi;
	private Date ngayKhoiHanh;
	private Date ngayKetThuc;
	private Image anh;
	/**
	 * @return the maChuyenDi
	 */
	public String getMaChuyenDi() {
		return maChuyenDi;
	}
	/**
	 * @param maChuyenDi the maChuyenDi to set
	 */
	public void setMaChuyenDi(String maChuyenDi) {
		this.maChuyenDi = maChuyenDi;
	}
	/**
	 * @return the tenChuyenDi
	 */
	public String getTenChuyenDi() {
		return tenChuyenDi;
	}
	/**
	 * @param tenChuyenDi the tenChuyenDi to set
	 */
	public void setTenChuyenDi(String tenChuyenDi) {
		this.tenChuyenDi = tenChuyenDi;
	}
	/**
	 * @return the ngayKhoiHanh
	 */
	public Date getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	/**
	 * @param ngayKhoiHanh the ngayKhoiHanh to set
	 */
	public void setNgayKhoiHanh(Date ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	/**
	 * @return the ngayKetThuc
	 */
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	/**
	 * @param ngayKetThuc the ngayKetThuc to set
	 */
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	/**
	 * @return the anh
	 */
	public Image getAnh() {
		return anh;
	}
	/**
	 * @param anh the anh to set
	 */
	public void setAnh(Image anh) {
		this.anh = anh;
	}
	/**
	 * @param maChuyenDi
	 * @param tenChuyenDi
	 * @param ngayKhoiHanh
	 * @param ngayKetThuc
	 * @param anh
	 */
	public ChuyenDi(String maChuyenDi, String tenChuyenDi, Date ngayKhoiHanh, Date ngayKetThuc, Image anh) {
		super();
		setMaChuyenDi(maChuyenDi);
		setTenChuyenDi(tenChuyenDi);
		setNgayKhoiHanh(ngayKhoiHanh);
		setNgayKetThuc(ngayKetThuc);
		setAnh(anh);
	}
	public ChuyenDi() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
