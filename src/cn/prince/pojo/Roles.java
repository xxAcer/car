package cn.prince.pojo;

public class Roles {
	private int roleid;
	private String rolename;
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
	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}
	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Roles(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}