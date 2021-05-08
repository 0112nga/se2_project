package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import IDAO.IFulfillmentDAO;
import Models.Barcode;
import Models.Fulfillment;
import Models.Location;
import Services.LocationService;
import config.dbConnection.dbConnection;

public class FulfillmentDAO implements IFulfillmentDAO{
	LocationService locationService = LocationService.getLocationService();
	Connection connection = dbConnection.getConnection();
	@Override
	public Fulfillment getFulfillment(int key) {
		Fulfillment fulfillment = new Fulfillment();
		String SELECT_FULFILLMENT = "SELECT * FROM fulfillment WHERE fulfillment_key = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_FULFILLMENT);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String email = rs.getString("email");
				String companyName = rs.getString("companyName");
				String currency = rs.getString("currency");
				double landingCost = rs.getDouble("landingCost");
				String phoneNumber = rs.getString("phoneNumber");
				int locationID = rs.getInt("locationID");
				Location location = locationService.getLocation(locationID);
				fulfillment = new Fulfillment(key, email, companyName, currency, landingCost, phoneNumber, location);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return fulfillment;
	}
	@Override
	public List<Fulfillment> getFulfillments() {
		List<Fulfillment> fulfillments = new ArrayList<Fulfillment>();
		String SELECT_ALL_FULFILLMENTS = "SELECT * FROM fulfillment;";
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_ALL_FULFILLMENTS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fulfillment_key = rs.getInt("fulfillment_key");
				String email = rs.getString("email");
				String companyName = rs.getString("companyName");
				String currency = rs.getString("currency");
				double landingCost = rs.getDouble("landingCost");
				String phoneNumber = rs.getString("phoneNumber");
				int locationID = rs.getInt("locationID");
				Location location = locationService.getLocation(locationID);
				fulfillments.add(new Fulfillment(fulfillment_key, email, companyName, currency, landingCost, phoneNumber, location));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return fulfillments;
	}
	@Override
	public Fulfillment updateFulfillment(Fulfillment f) {
		Fulfillment fulfillment = new Fulfillment();
		Location location = f.getLocation();
		fulfillment.setLocation(location);
		String UPDATE= "UPDATE fulfillment SET email=?,companyName=?,currency=?,phoneNumber=?,landingCost=?,locationID=? WHERE fulfillment_key = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE);
			ps.setString(1, f.getEmail());
			fulfillment.setEmail(f.getEmail());
			ps.setString(2, f.getCompanyName());
			fulfillment.setCompanyName(f.getCompanyName());
			ps.setString(3, f.getCurrency());
			fulfillment.setCurrency(f.getCurrency());
			ps.setString(4, f.getPhoneNumber());
			fulfillment.setPhoneNumber(f.getPhoneNumber());
			ps.setDouble(5, f.getLandingCost());
			fulfillment.setLandingCost(f.getLandingCost());
			ps.setInt(6, location.getId());
			ps.setInt(7, f.getFulfillment_key());
			fulfillment.setFulfillment_key(f.getFulfillment_key());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}
