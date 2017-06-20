package cn.prince.pojo;

public class Logs {
	private int id;
	private String username;
	private String action;
	private String actiontime;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the actiontime
	 */
	public String getActiontime() {
		return actiontime;
	}
	/**
	 * @param actiontime the actiontime to set
	 */
	public void setActiontime(String actiontime) {
		this.actiontime = actiontime;
	}
	public Logs(int id, String username, String action, String actiontime) {
		super();
		this.id = id;
		this.username = username;
		this.action = action;
		this.actiontime = actiontime;
	}
	public Logs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
