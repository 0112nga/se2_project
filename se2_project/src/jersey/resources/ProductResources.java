package jersey.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Models.Product;
import Services.ProductService;

@Path("/products")
public class ProductResources {
	ProductService service = ProductService.getProductService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getAllProducts()).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product){
		return service.createProduct(product);
	}
	
	@PUT
	@Path("/product/put")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Product updateProduct(Product product){
		return service.updateProduct(product);
	}

	@DELETE
	@Path("product/{sku}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Product deleteProduct(@PathParam("sku") String sku){
		return service.deleteProduct(sku);
	}
	
	
	@GET
	@Path("/product/{sku}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@PathParam("sku") String sku) {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getProduct(sku)).build();
	}
	@GET
	@Path("reserved")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservedProducts() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getAllReservedProducts()).build();
	}
	@GET
	@Path("onHand")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOnHandProduct() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getAllOnHandProduct()).build();
	}

	@GET
	@Path("committed")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommittedProducts() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getAllCommittedProducts()).build();
	}
	@GET
	@Path("awaiting")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAwaitingProducts() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getAllAwaitingProducts()).build();
	}
	@GET
	@Path("price/totalOnHand/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTotalOnHandPrice(@PathParam("name") String name) {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getToTalPrice(name)).build();
	
	}
	@GET
	@Path("fulfillment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByFulfillment(@PathParam("id") int id) {
		System.out.println(service.getProductsByFullfil(id));
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getProductsByFullfil(id)).build();
	}
	
}
