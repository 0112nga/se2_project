package Services;

import DAO.LocationDAO;
import IDAO.ILocationDAO;
import Models.Location;


public class LocationService {
	private ILocationDAO locationDAO;
	private static LocationService service;
	
	public LocationService() {
		super();
		locationDAO = new LocationDAO();
	}
	public static LocationService getLocationService() {
		if(service == null) {
			service = new LocationService();
		}
		return service;
	}
	
	public Location getLocation(int id){
		return locationDAO.getLocation(id);
	}

}
