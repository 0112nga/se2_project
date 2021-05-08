package Test;

public class SimpleTestcaseStatusPOJO {
	private boolean isAvailable;
	private String warehouse;
	
	public SimpleTestcaseStatusPOJO() {
		super();
	}

	public SimpleTestcaseStatusPOJO(boolean isAvailable, String warehouse) {
		super();
		this.isAvailable = isAvailable;
		this.warehouse = warehouse;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	

}
