package Models;

public class Barcode {
	private String EANorUPC;
	private String productBarcodeURL;
	
	
	public Barcode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Barcode(String eANorUPC, String productBarcodeURL) {
		super();
		EANorUPC = eANorUPC;
		this.productBarcodeURL = productBarcodeURL;
	}

	public String getEANorUPC() {
		return EANorUPC;
	}

	public void setEANorUPC(String eANorUPC) {
		EANorUPC = eANorUPC;
	}

	public String getProductBarcodeURL() {
		return productBarcodeURL;
	}

	public void setProductBarcodeURL(String productBarcodeURL) {
		this.productBarcodeURL = productBarcodeURL;
	}

	@Override
	public String toString() {
		return "Barcode [EANorUPC=" + EANorUPC + ", productBarcodeURL=" + productBarcodeURL + "]";
	}
	
	
	

}
