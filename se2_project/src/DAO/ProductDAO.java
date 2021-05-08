package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IDAO.IProductDAO;
import Models.Barcode;
import Models.Fulfillment;
import Models.Product;
import Services.BarcodeService;
import Services.FulfillmentService;
import config.dbConnection.dbConnection;


public class ProductDAO implements IProductDAO{
	//Connect to db
	Connection connection = dbConnection.getConnection();
	FulfillmentService fulfillmentService = FulfillmentService.getFulfillmentService();
	BarcodeService barcodeService = BarcodeService.getBarcodeService();
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		String SELECT_ALL_PRODUCTS = "SELECT * FROM product;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public Product getProduct(String SKU) {
		Product product = new Product();
		String SELECT_PRODUCT = "SELECT * FROM product WHERE SKU = ?;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT);
			ps.setString(1, SKU);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				product = new Product(SKU, productImgURL, barcode, description, onHand, UOM, reservedQty, committedQty, awatingQty, sellingPrice, category, tradeMark, fulfillment, purchasePrice);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public List<Product> getAllOnHandProducts() {
		List<Product> products = new ArrayList<Product>();
		String SELECT_ONHAND_PRODUCTS = "SELECT * FROM product WHERE NOT onHand = 0;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ONHAND_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public List<Product> getAllReservedProducts() {
		List<Product> products = new ArrayList<Product>();
		String SELECT_RESERVED_PRODUCTS = "SELECT * FROM product WHERE NOT reservedQty = 0;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_RESERVED_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public List<Product> getAllCommittedProducts() {
		List<Product> products = new ArrayList<Product>();
		String SELECT_COMMITTED_PRODUCTS = "SELECT * FROM product WHERE NOT committedQty = 0;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_COMMITTED_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public List<Product> getAllAwaitingProducts() {
		List<Product> products = new ArrayList<Product>();
		String SELECT_AWAITING_PRODUCTS = "SELECT * FROM product WHERE NOT awatingQty = 0;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_AWAITING_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public int getTotalAwaitingProducts() {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(awatingQty) AS TotalAwaiting FROM product;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalAwaiting");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalOnHandProducts() {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(onHand) AS TotalOnHand FROM product;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalOnHand");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalCommittedProducts() {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(committedQty) AS TotalCommitted FROM product;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalCommitted");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalReservedProducts() {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(reservedQty) AS TotalReserved FROM product;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalReserved");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public List<Product> getProductsByFullfil(int key) {
		List<Product> products = new ArrayList<Product>();
		String SELECT_PRODUCT = "SELECT * FROM product WHERE fulfillment_key = ?;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String SKU = rs.getString("SKU");
				String productImgURL = rs.getString("productImgURL");
				String barcodeID = rs.getString("barcodeID");
				String description = rs.getString("description");
				int onHand = rs.getInt("onHand");
				String UOM = rs.getString("UOM");
				int reservedQty = rs.getInt("reservedQty");
				int committedQty = rs.getInt("committedQty");
				int awatingQty = rs.getInt("awatingQty");
				double sellingPrice = rs.getDouble("sellingPrice");
				String category = rs.getString("category");
				String tradeMark = rs.getString("tradeMark");
				int fulfillment_key = rs.getInt("fulfillment_key");
				double purchasePrice = rs.getDouble("purchasePrice");
				Fulfillment fulfillment = fulfillmentService.getFulfillment(fulfillment_key);
				Barcode barcode = barcodeService.getBarcode(barcodeID);
				products.add(new Product(SKU, productImgURL,barcode,description, onHand, UOM, reservedQty, committedQty, 
						awatingQty, sellingPrice, category, tradeMark,fulfillment,purchasePrice));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public int getTotalOnHandProductsByFullfil(int key) {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(onHand) AS TotalOnHand FROM product WHERE fulfillment_key = ?;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalOnHand");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalReservedProductsByFullfil(int key) {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(reservedQty) AS TotalReserved FROM product WHERE fulfillment_key = ?;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalReserved");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalAwaitingProductsByFullfil(int key) {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(awatingQty) AS TotalAwaiting FROM product WHERE fulfillment_key = ?;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalAwaiting");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalCommittedProductsByFullfil(int key) {
		String SELECT_TOTAL_PRODUCTS = "SELECT SUM(committedQty) AS TotalCommitted FROM product WHERE fulfillment_key = ?;";
		int total = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_TOTAL_PRODUCTS);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total = rs.getInt("TotalCommitted");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public Product createProduct(Product product) {
		String INSERT_PRODUCT = "INSERT INTO `product` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		int valid = barcodeService.createBarcode(product.getBarcode());
		int row = 0;
		if(valid > 0) {
			try {
				PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT);
				ps.setString(1, product.getSKU());
				ps.setString(2, product.getProductImgURL());
				ps.setString(3, product.getBarcode().getEANorUPC());
				ps.setString(4, product.getDescription());
				ps.setInt(5, product.getOnHand());
				ps.setString(6, product.getUOM());
				ps.setInt(7, product.getReservedQty());
				ps.setInt(8, product.getCommittedQty());
				ps.setInt(9, product.getAwatingQty());
				ps.setDouble(10, product.getSellingPrice());
				ps.setString(11, product.getCategory());
				ps.setString(12, product.getTradeMark());
				ps.setInt(13, product.getFulfillment_key());
				ps.setDouble(14, product.getPurchasePrice());
				row = ps.executeUpdate();
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}
	@Override
	public Product updateProduct(Product product) {
		String UPDATE_PRODUCT = "UPDATE product SET productImgURL=?, barcodeID=?, description=?, onHand=?,"
				+ "UOM=?,reservedQty=?,committedQty=?,awatingQty=?,sellingPrice=?,category=?,tradeMark=?,fulfillment_key=?"
				+ "purchasePrice=? WHERE SKU = ?;";
		String INSERT_PRODUCT = "INSERT INTO `product` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE;";
		String query = "INSERT INTO `product` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		String DELETE_PRODUCT = "DELETE FROM product WHERE SKU=?";
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT);
			ps.setString(1, product.getSKU());
			ps.setString(2, product.getProductImgURL());
			ps.setString(3, product.getBarcode().getEANorUPC());
			ps.setString(4, product.getDescription());
			ps.setInt(5, product.getOnHand());
			ps.setString(6, product.getUOM());
			ps.setInt(7, product.getReservedQty());
			ps.setInt(8, product.getCommittedQty());
			ps.setInt(9, product.getAwatingQty());
			ps.setDouble(10, product.getSellingPrice());
			ps.setString(11, product.getCategory());
			ps.setString(12, product.getTradeMark());
			ps.setInt(13, product.getFulfillment_key());
			ps.setDouble(14, product.getPurchasePrice());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public Product deleteProduct(String sku) {
		String DELETE_PRODUCT = "DELETE FROM product WHERE SKU=?";
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT);
			ps.setString(1, sku);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return getProduct(sku);
		
		
	}

	
	
}
