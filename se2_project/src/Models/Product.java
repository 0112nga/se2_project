package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private String SKU;
	private String productImgURL;
	private Barcode barcode;
	private String description;
	private int onHand;
	private String UOM;
	private int reservedQty;
	private int committedQty;
	private int awatingQty;
	private double sellingPrice;
	private String category;
	private String tradeMark;
	private Fulfillment fulfillment;
	private int fulfillment_key;
	private double purchasePrice;
	
	public Product() {
		super();
	}
	
	public Product(String sKU, String productImgURL, Barcode barcode, String description, int onHand, String uOM,
			int reservedQty, int committedQty, int awatingQty, double sellingPrice, String category, String tradeMark,
			int fulfillment_key, double purchasePrice) {
		super();
		SKU = sKU;
		this.productImgURL = productImgURL;
		this.description = description;
		this.barcode = barcode;
		this.onHand = onHand;
		UOM = uOM;
		this.reservedQty = reservedQty;
		this.committedQty = committedQty;
		this.awatingQty = awatingQty;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.tradeMark = tradeMark;
		this.fulfillment_key = fulfillment_key;
		this.purchasePrice = purchasePrice;
	}

	public Product(String sKU, String productImgURL, Barcode barcode,String description, int onHand, String uOM, int reservedQty,
			int committedQty, int awatingQty, double sellingPrice, String category, String tradeMark,Fulfillment fulfillment,double purchasePrice ) {
		super();
		SKU = sKU;
		this.productImgURL = productImgURL;
		this.barcode = barcode;
		this.description = description;
		this.onHand = onHand;
		UOM = uOM;
		this.reservedQty = reservedQty;
		this.committedQty = committedQty;
		this.awatingQty = awatingQty;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.tradeMark = tradeMark;
		this.fulfillment = fulfillment;
		this.purchasePrice = purchasePrice;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOnHand() {
		return onHand;
	}
	public void setOnHand(int onHand) {
		this.onHand = onHand;
	}
	public String getUOM() {
		return UOM;
	}
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	public int getReservedQty() {
		return reservedQty;
	}
	public void setReservedQty(int reservedQty) {
		this.reservedQty = reservedQty;
	}
	public int getCommittedQty() {
		return committedQty;
	}
	public void setCommittedQty(int committedQty) {
		this.committedQty = committedQty;
	}
	public int getAwatingQty() {
		return awatingQty;
	}
	public void setAwatingQty(int awatingQty) {
		this.awatingQty = awatingQty;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public String getProductImgURL() {
		return productImgURL;
	}
	public void setProductImgURL(String productImgURL) {
		this.productImgURL = productImgURL;
	}
	
	public Barcode getBarcode() {
		return barcode;
	}
	public void setBarcode(Barcode barcode) {
		this.barcode = barcode;
	}
	
	public Fulfillment getFulfillment() {
		return fulfillment;
	}
	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchase) {
		this.purchasePrice = purchase;
	}
	public int getFulfillment_key() {
		return fulfillment_key;
	}

	public void setFulfillment_key(int fulfillment_key) {
		this.fulfillment_key = fulfillment_key;
	}

	@Override
	public String toString() {
		return "Product [SKU=" + SKU + ", productImgURL=" + productImgURL + ", barcode=" + barcode.toString() + ", description="
				+ description + ", onHand=" + onHand + ", UOM=" + UOM + ", reservedQty=" + reservedQty
				+ ", committedQty=" + committedQty + ", awatingQty=" + awatingQty + ", sellingPrice=" + sellingPrice
				+ ", category=" + category + ", tradeMark=" + tradeMark + ", fulfillment=" + fulfillment + ", purchasePrice="
				+ purchasePrice + "]";
	}
	
	
}
