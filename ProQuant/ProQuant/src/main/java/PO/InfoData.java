package PO;
// default package
// Generated 2017-5-25 12:54:38 by Hibernate Tools 4.0.1.Final

/**
 * InfoData generated by hbm2java
 */
public class InfoData implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3955144798072263444L;
	private long id;
	private String code;
	private String name;
	private String CName;
	private Byte board;
	private String cpName;
	private String cpProvince;
	private String cpEnName;
	private String cpWebsite;
	private String cpBusiness;
	private String cpAddress;
	private String cpInfo;

	public InfoData() {
	}

	public InfoData(long id) {
		this.id = id;
	}

	public InfoData(long id, String code, String name, String CName, Byte board, String cpName, String cpProvince,
			String cpEnName, String cpWebsite, String cpBusiness, String cpAddress, String cpInfo) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.CName = CName;
		this.board = board;
		this.cpName = cpName;
		this.cpProvince = cpProvince;
		this.cpEnName = cpEnName;
		this.cpWebsite = cpWebsite;
		this.cpBusiness = cpBusiness;
		this.cpAddress = cpAddress;
		this.cpInfo = cpInfo;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public Byte getBoard() {
		return this.board;
	}

	public void setBoard(Byte board) {
		this.board = board;
	}

	public String getCpName() {
		return this.cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public String getCpProvince() {
		return this.cpProvince;
	}

	public void setCpProvince(String cpProvince) {
		this.cpProvince = cpProvince;
	}

	public String getCpEnName() {
		return this.cpEnName;
	}

	public void setCpEnName(String cpEnName) {
		this.cpEnName = cpEnName;
	}

	public String getCpWebsite() {
		return this.cpWebsite;
	}

	public void setCpWebsite(String cpWebsite) {
		this.cpWebsite = cpWebsite;
	}

	public String getCpBusiness() {
		return this.cpBusiness;
	}

	public void setCpBusiness(String cpBusiness) {
		this.cpBusiness = cpBusiness;
	}

	public String getCpAddress() {
		return this.cpAddress;
	}

	public void setCpAddress(String cpAddress) {
		this.cpAddress = cpAddress;
	}

	public String getCpInfo() {
		return this.cpInfo;
	}

	public void setCpInfo(String cpInfo) {
		this.cpInfo = cpInfo;
	}

	@Override
	public String toString() {
		return "InfoData [id=" + id + ", code=" + code + ", name=" + name + ", CName=" + CName + ", board=" + board
				+ ", cpName=" + cpName + ", cpProvince=" + cpProvince + ", cpEnName=" + cpEnName + ", cpWebsite="
				+ cpWebsite + ", cpBusiness=" + cpBusiness + ", cpAddress=" + cpAddress + ", cpInfo=" + cpInfo + "]";
	}

}
