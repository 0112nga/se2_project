package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import IDAO.ILocationDAO;
import Models.Location;
import config.dbConnection.dbConnection;

public class LocationDAO implements ILocationDAO{
	Connection connection = dbConnection.getConnection();
	@Override
	public Location getLocation(int id) {
		Location location = new Location();
		String SELECT_LOCATION = "SELECT * FROM location WHERE id = ?;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_LOCATION);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				int zipcode = rs.getInt("zipcode");
				location = new Location(address, city, state, country, zipcode);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return location;
	}

}
