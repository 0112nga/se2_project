package Services;

import java.util.List;

import DAO.FulfillmentDAO;
import IDAO.IFulfillmentDAO;
import Models.Fulfillment;

public class FulfillmentService {
	private static FulfillmentService service;
	private IFulfillmentDAO fulfillmentDAO;
	
	private FulfillmentService() {
		super();
		fulfillmentDAO = new FulfillmentDAO();
	}
	public static FulfillmentService getFulfillmentService() {
		if(service == null) {
			service = new FulfillmentService();
		}
		return service;
	}
	public Fulfillment getFulfillment(int key) {
		return fulfillmentDAO.getFulfillment(key);
	}
	public List<Fulfillment> getFulfillments() {
		return fulfillmentDAO.getFulfillments();
	}
	public Fulfillment updateFulfillment(Fulfillment f) {
		return fulfillmentDAO.updateFulfillment(f);
	}

}
