package cn.prince.pojo;

public class Loginlogs {
	private int loginlogid;
	private String loginname;
	private String loginip;
	private String logintime;
	/**
	 * @return the loginlogid
	 */
	public int getLoginlogid() {
		return loginlogid;
	}
	/**
	 * @param loginlogid the loginlogid to set
	 */
	public void setLoginlogid(int loginlogid) {
		this.loginlogid = loginlogid;
	}
	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * @param loginname the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * @return the loginip
	 */
	public String getLoginip() {
		return loginip;
	}
	/**
	 * @param loginip the loginip to set
	 */
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	/**
	 * @return the logintime
	 */
	public String getLogintime() {
		return logintime;
	}
	/**
	 * @param logintime the logintime to set
	 */
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public Loginlogs(int loginlogid, String loginname, String loginip, String logintime) {
		super();
		this.loginlogid = loginlogid;
		this.loginname = loginname;
		this.loginip = loginip;
		this.logintime = logintime;
	}
	public Loginlogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
