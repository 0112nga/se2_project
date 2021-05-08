package Models;

import java.util.List;

public class ComplexProducts {
	private List<Product> products;
	private double totalPrice;
	private int totalOnHand;
	private int totalReserved;
	private int totalCommitted;
	private int totalAwaiting;
	public ComplexProducts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComplexProducts(List<Product> products) {
		super();
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalOnHand() {
		return totalOnHand;
	}
	public void setTotalOnHand(int totalOnHand) {
		this.totalOnHand = totalOnHand;
	}
	public int getTotalReserved() {
		return totalReserved;
	}
	public void setTotalReserved(int totalReserved) {
		this.totalReserved = totalReserved;
	}
	public int getTotalCommitted() {
		return totalCommitted;
	}
	public void setTotalCommitted(int totalCommitted) {
		this.totalCommitted = totalCommitted;
	}
	public int getTotalAwaiting() {
		return totalAwaiting;
	}
	public void setTotalAwaiting(int totalAwaiting) {
		this.totalAwaiting = totalAwaiting;
	}
	

}
