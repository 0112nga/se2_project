package Test;

import java.time.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
public class SimpleTestcaseJsonPOJO {
	private String productName;
	private Double price;
	private int quantity;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate date;
	private List<SimpleTestcaseStatusPOJO> status;
	
	public SimpleTestcaseJsonPOJO() {
	}
	
	public SimpleTestcaseJsonPOJO(String productName, Double price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<SimpleTestcaseStatusPOJO> getStatus() {
		return status;
	}

	public void setStatus(List<SimpleTestcaseStatusPOJO> status) {
		this.status = status;
	}
	
	
	

}
