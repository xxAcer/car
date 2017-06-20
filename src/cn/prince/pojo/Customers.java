package cn.prince.pojo;

public class Customers {
	private int id;
	private String cname;
	private String cpwd;
	private String custname;
	private String sex;
	private String address;
	private String phone;
	private String career;
	private int roleid ;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the cpwd
	 */
	public String getCpwd() {
		return cpwd;
	}
	/**
	 * @param cpwd the cpwd to set
	 */
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	/**
	 * @return the custname
	 */
	public String getCustname() {
		return custname;
	}
	/**
	 * @param custname the custname to set
	 */
	public void setCustname(String custname) {
		this.custname = custname;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the career
	 */
	public String getCareer() {
		return career;
	}
	/**
	 * @param career the career to set
	 */
	public void setCareer(String career) {
		this.career = career;
	}
	/**
	 * @return the roleid
	 */
	public int getRoleid() {
		return roleid;
	}
	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int id, String cname, String cpwd, String custname, String sex, String address, String phone,
			String career, int roleid) {
		super();
		this.id = id;
		this.cname = cname;
		this.cpwd = cpwd;
		this.custname = custname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.career = career;
		this.roleid = roleid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customers [id=" + id + ", cname=" + cname + ", cpwd=" + cpwd + ", custname=" + custname + ", sex=" + sex
				+ ", address=" + address + ", phone=" + phone + ", career=" + career + ", roleid=" + roleid + "]";
	}
	
	
	
	
	
}
