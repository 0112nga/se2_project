package IDAO;

import java.util.List;

import Models.Fulfillment;

public interface IFulfillmentDAO {
	Fulfillment getFulfillment(int key);
	List<Fulfillment> getFulfillments();
	Fulfillment updateFulfillment(Fulfillment f);
}
