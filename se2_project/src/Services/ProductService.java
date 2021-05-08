package Services;

import java.util.List;

import DAO.ProductDAO;
import IDAO.IProductDAO;
import Models.ComplexProducts;
import Models.Product;

public class ProductService {
	private IProductDAO productDAO;
	private static ProductService service;
	
	public ProductService() {
		super();
		productDAO = new ProductDAO();
	}
	public static ProductService getProductService() {
		if(service == null) {
			service = new ProductService();
		}
		return service;
	}
	
	public ComplexProducts getAllProducts(){
		List<Product> products = productDAO.getAllProducts();
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProducts());
		c.setTotalReserved(productDAO.getTotalReservedProducts());
		c.setTotalCommitted(productDAO.getTotalCommittedProducts());
		c.setTotalAwaiting(productDAO.getTotalAwaitingProducts());
		return c;
	}
	public Product getProduct(String SKU){
		return productDAO.getProduct(SKU);
	}
	public ComplexProducts getAllOnHandProduct(){
		List<Product> products = productDAO.getAllOnHandProducts();
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProducts());
		c.setTotalReserved(productDAO.getTotalReservedProducts());
		c.setTotalCommitted(productDAO.getTotalCommittedProducts());
		c.setTotalAwaiting(productDAO.getTotalAwaitingProducts());
		return c;
	}
	public ComplexProducts getAllReservedProducts(){
		List<Product> products = productDAO.getAllReservedProducts();
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProducts());
		c.setTotalReserved(productDAO.getTotalReservedProducts());
		c.setTotalCommitted(productDAO.getTotalCommittedProducts());
		c.setTotalAwaiting(productDAO.getTotalAwaitingProducts());
		return c;
	}
	public ComplexProducts getAllCommittedProducts(){
		List<Product> products = productDAO.getAllCommittedProducts();
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProducts());
		c.setTotalReserved(productDAO.getTotalReservedProducts());
		c.setTotalCommitted(productDAO.getTotalCommittedProducts());
		c.setTotalAwaiting(productDAO.getTotalAwaitingProducts());
		
		return c;
	}
	public ComplexProducts getAllAwaitingProducts(){
		List<Product> products = productDAO.getAllAwaitingProducts();
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProducts());
		c.setTotalReserved(productDAO.getTotalReservedProducts());
		c.setTotalCommitted(productDAO.getTotalCommittedProducts());
		c.setTotalAwaiting(productDAO.getTotalAwaitingProducts());
		return c;
	}
	public ComplexProducts getProductsByFullfil(int key){
		List<Product> products = productDAO.getProductsByFullfil(key);
		ComplexProducts c = new ComplexProducts(products);
		c.setTotalPrice(getTotalOnHandPrice(products));
		c.setTotalOnHand(productDAO.getTotalOnHandProductsByFullfil(key));
		c.setTotalReserved(productDAO.getTotalReservedProductsByFullfil(key));
		c.setTotalCommitted(productDAO.getTotalCommittedProductsByFullfil(key));
		c.setTotalAwaiting(productDAO.getTotalAwaitingProductsByFullfil(key));
		return c;
	}
	public double getToTalPrice(String name) {
		if(name.equals("onHand")) {
			return getTotalOnHandPrice(productDAO.getAllOnHandProducts());
		}
		if(name.equals("reserved")) {
			return getTotalOnHandPrice( productDAO.getAllReservedProducts());
		}
		if(name.equals("committed")) {
			return getTotalOnHandPrice(productDAO.getAllCommittedProducts());
		}
		if(name.equals("awaiting")) {
			return getTotalOnHandPrice(productDAO.getAllAwaitingProducts());
		}
		return 0;
	}
	private double getTotalOnHandPrice(List<Product> products) {
		double total = 0;
		for(Product p : products) {
			total += p.getOnHand()*p.getSellingPrice();
		}
		return total;
	}
	public Product createProduct(Product product) {
		
		return productDAO.createProduct(product);
	}
	public Product updateProduct(Product product) {
		
		return productDAO.updateProduct(product);
	}
	public Product deleteProduct(String sku) {
		 return productDAO.deleteProduct(sku);
	}
	

}
