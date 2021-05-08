package jersey.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Models.Fulfillment;
import Models.Product;
import Services.FulfillmentService;

@Path("/fulfillment")
public class FulfillmentResources {
	FulfillmentService service = FulfillmentService.getFulfillmentService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFulfillments() {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getFulfillments()).build();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFulfillment(@PathParam("id") int id) {
		return Response.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.entity(service.getFulfillment(id)).build();
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fulfillment updateFulfillment(Fulfillment f){
		return service.updateFulfillment(f);
	}
	

}
