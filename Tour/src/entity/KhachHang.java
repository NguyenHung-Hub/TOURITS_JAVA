package entity;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	/**
	 * @return the maKhachHang
	 */
	public String getMaKhachHang() {
		return maKhachHang;
	}
	/**
	 * @param maKhachHang the maKhachHang to set
	 */
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	/**
	 * @return the tenKhachHang
	 */
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	/**
	 * @param tenKhachHang the tenKhachHang to set
	 */
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	/**
	 * @return the gioiTinh
	 */
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}
	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	/**
	 * @return the soDienThoai
	 */
	public String getSoDienThoai() {
		return soDienThoai;
	}
	/**
	 * @param soDienThoai the soDienThoai to set
	 */
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @param maKhachHang
	 * @param tenKhachHang
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param soDienThoai
	 * @param email
	 * @param diaChi
	 */
	public KhachHang(String maKhachHang, String tenKhachHang, boolean gioiTinh, Date ngaySinh, String soDienThoai,
			String email, String diaChi) {
		super();
		setMaKhachHang(maKhachHang);
		setTenKhachHang(tenKhachHang);
		setGioiTinh(gioiTinh);
		setNgaySinh(ngaySinh);
		setSoDienThoai(soDienThoai);
		setEmail(email);
		setDiaChi(diaChi);
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
