package model;

import java.sql.Date;
import java.util.List;

public class Orders {
	private int orderID;
	private double price;// total amount of order
	private int status;
	private Date orderDate;
	private String address; // buyer address
	private String phoneNumber;
	private List<Product> lp;
	private String userMail;// buyer email
	private Date receiveDate;
	private String discount;

	public Orders() {
		super();
	}

	public Orders(int orderID, double price, int status, Date orderDate, String address, String phoneNumber,
			List<Product> lp, String userMail, Date receiveDate, String discount) {
		super();
		this.orderID = orderID;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userMail = userMail;
		this.receiveDate = receiveDate;
		this.discount = discount;
	}

	public int getOrderID() {
		return orderID;
	}

	public double getPrice() {
		return price;
	}

	public int getStatus() {
		return status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public List<Product> getLp() {
		return lp;
	}

	public String getUserMail() {
		return userMail;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setLp(List<Product> lp) {
		this.lp = lp;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", price=" + price + ", status=" + status + ", orderDate=" + orderDate
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", lp=" + lp + ", userMail=" + userMail
				+ ", receiveDate=" + receiveDate + ", discount=" + discount + "]";
	}
	
	
}
