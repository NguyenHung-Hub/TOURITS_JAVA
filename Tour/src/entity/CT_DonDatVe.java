package entity;

public class CT_DonDatVe {
	private DonDatVe donDatVe;
	private ChuyenDi chuyenDi;
	private int soLuong;
	private double donGia;
	/**
	 * @return the donDatVe
	 */
	public DonDatVe getDonDatVe() {
		return donDatVe;
	}
	/**
	 * @param donDatVe the donDatVe to set
	 */
	public void setDonDatVe(DonDatVe donDatVe) {
		this.donDatVe = donDatVe;
	}
	/**
	 * @return the chuyenDi
	 */
	public ChuyenDi getChuyenDi() {
		return chuyenDi;
	}
	/**
	 * @param chuyenDi the chuyenDi to set
	 */
	public void setChuyenDi(ChuyenDi chuyenDi) {
		this.chuyenDi = chuyenDi;
	}
	/**
	 * @return the soLuong
	 */
	public int getSoLuong() {
		return soLuong;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}
	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	/**
	 * @param donDatVe
	 * @param chuyenDi
	 * @param soLuong
	 * @param donGia
	 */
	public CT_DonDatVe(DonDatVe donDatVe, ChuyenDi chuyenDi, int soLuong, double donGia) {
		super();
		setDonDatVe(donDatVe);
		setChuyenDi(chuyenDi);
		setSoLuong(soLuong);
		setDonGia(donGia);
	}
	public CT_DonDatVe() {
		// TODO Auto-generated constructor stub
	}
}
