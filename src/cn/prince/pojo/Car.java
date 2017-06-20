package cn.prince.pojo;

public class Car {
	private int carnumber;
	private String cartype;
	private String color;
	private String price;
	private String rentprice;
	private String deposit;
	private String isrenting;
	private String description;
	/**
	 * @return the carnumber
	 */
	public int getCarnumber() {
		return carnumber;
	}
	/**
	 * @param carnumber the carnumber to set
	 */
	public void setCarnumber(int carnumber) {
		this.carnumber = carnumber;
	}
	/**
	 * @return the cartype
	 */
	public String getCartype() {
		return cartype;
	}
	/**
	 * @param cartype the cartype to set
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the rentprice
	 */
	public String getRentprice() {
		return rentprice;
	}
	/**
	 * @param rentprice the rentprice to set
	 */
	public void setRentprice(String rentprice) {
		this.rentprice = rentprice;
	}
	/**
	 * @return the deposit
	 */
	public String getDeposit() {
		return deposit;
	}
	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	/**
	 * @return the isrenting
	 */
	public String getIsrenting() {
		return isrenting;
	}
	/**
	 * @param isrenting the isrenting to set
	 */
	public void setIsrenting(String isrenting) {
		this.isrenting = isrenting;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public Car(int carnumber, String cartype, String color, String price, String rentprice, String deposit,
			String isrenting, String description) {
		super();
		this.carnumber = carnumber;
		this.cartype = cartype;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.isrenting = isrenting;
		this.description = description;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [carnumber=" + carnumber + ", cartype=" + cartype + ", color=" + color + ", price=" + price
				+ ", rentprice=" + rentprice + ", deposit=" + deposit + ", isrenting=" + isrenting + ", description="
				+ description + "]";
	}
	
	
	
}