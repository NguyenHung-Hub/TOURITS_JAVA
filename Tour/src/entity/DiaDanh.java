package entity;

public class DiaDanh {
	private String maDiaDanh;
	private String tenDiaDanh;
	private String tinhThanh;
	/**
	 * @return the maDiaDanh
	 */
	public String getMaDiaDanh() {
		return maDiaDanh;
	}
	/**
	 * @param maDiaDanh the maDiaDanh to set
	 */
	public void setMaDiaDanh(String maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}
	/**
	 * @return the tenDiaDanh
	 */
	public String getTenDiaDanh() {
		return tenDiaDanh;
	}
	/**
	 * @param tenDiaDanh the tenDiaDanh to set
	 */
	public void setTenDiaDanh(String tenDiaDanh) {
		this.tenDiaDanh = tenDiaDanh;
	}
	/**
	 * @return the tinhThanh
	 */
	public String getTinhThanh() {
		return tinhThanh;
	}
	/**
	 * @param tinhThanh the tinhThanh to set
	 */
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	/**
	 * @param maDiaDanh
	 * @param tenDiaDanh
	 * @param tinhThanh
	 */
	public DiaDanh(String maDiaDanh, String tenDiaDanh, String tinhThanh) {
		super();
		setMaDiaDanh(maDiaDanh);
		setTenDiaDanh(tenDiaDanh);
		setTinhThanh(tinhThanh);
	}
	public DiaDanh() {
		// TODO Auto-generated constructor stub
	}
}
