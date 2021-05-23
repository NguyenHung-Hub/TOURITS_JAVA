package entity;

import java.sql.Date;

public class DonDatVe {
	private String maDonDatVe;
	private Date ngayDatVe;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private double tongTien;
	/**
	 * @return the maDonDatVe
	 */
	public String getMaDonDatVe() {
		return maDonDatVe;
	}
	/**
	 * @param maDonDatVe the maDonDatVe to set
	 */
	public void setMaDonDatVe(String maDonDatVe) {
		this.maDonDatVe = maDonDatVe;
	}
	/**
	 * @return the ngayDatVe
	 */
	public Date getNgayDatVe() {
		return ngayDatVe;
	}
	/**
	 * @param ngayDatVe the ngayDatVe to set
	 */
	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	/**
	 * @return the khachHang
	 */
	public KhachHang getKhachHang() {
		return khachHang;
	}
	/**
	 * @param khachHang the khachHang to set
	 */
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	/**
	 * @return the nhanVien
	 */
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	/**
	 * @param nhanVien the nhanVien to set
	 */
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	/**
	 * @return the tongTien
	 */
	public double getTongTien() {
		return tongTien;
	}
	/**
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	/**
	 * @param maDonDatVe
	 * @param ngayDatVe
	 * @param khachHang
	 * @param nhanVien
	 * @param tongTien
	 */
	public DonDatVe(String maDonDatVe, Date ngayDatVe, KhachHang khachHang, NhanVien nhanVien, double tongTien) {
		super();
		setMaDonDatVe(maDonDatVe);
		setNgayDatVe(ngayDatVe);
		setKhachHang(khachHang);
		setNhanVien(nhanVien);
		setTongTien(tongTien);
	}
	public DonDatVe() {
		// TODO Auto-generated constructor stub
	}
}
