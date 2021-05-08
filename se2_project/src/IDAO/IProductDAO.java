package IDAO;

import java.util.List;

import Models.Product;

public interface IProductDAO {
	List<Product> getAllProducts();
	Product getProduct(String SKU);
	List<Product> getAllOnHandProducts();
	List<Product> getAllReservedProducts();
	List<Product> getAllCommittedProducts();
	List<Product> getAllAwaitingProducts();
	List<Product> getProductsByFullfil(int key);
	int getTotalAwaitingProducts();
	int getTotalOnHandProducts();
	int getTotalCommittedProducts();
	int getTotalReservedProducts();
	int getTotalOnHandProductsByFullfil(int key);
	int getTotalReservedProductsByFullfil(int key);
	int getTotalAwaitingProductsByFullfil(int key);
	int getTotalCommittedProductsByFullfil(int key);
	Product createProduct(Product product);
	Product updateProduct(Product product);
	Product deleteProduct(String sku);
}
