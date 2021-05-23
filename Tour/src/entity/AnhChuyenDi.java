package entity;

public class AnhChuyenDi {
	private ChuyenDi chuyenDi;
	private byte[] anh;
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
	 * @return the anh
	 */
	public byte[] getAnh() {
		return anh;
	}
	/**
	 * @param anh the anh to set
	 */
	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	/**
	 * @param chuyenDi
	 * @param anh
	 */
	public AnhChuyenDi(ChuyenDi chuyenDi, byte[] anh) {
		super();
		setChuyenDi(chuyenDi);
		setAnh(anh);
	}
	public AnhChuyenDi() {
		// TODO Auto-generated constructor stub
	}
}
