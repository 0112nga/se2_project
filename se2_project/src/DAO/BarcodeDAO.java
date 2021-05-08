package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import IDAO.IBarcodeDAO;
import Models.Barcode;
import config.dbConnection.dbConnection;

public class BarcodeDAO implements IBarcodeDAO{
	Connection connection = dbConnection.getConnection();
	@Override
	public Barcode getBarcode(String barcodeID) {
		Barcode barcode = new Barcode();
		String SELECT_BARCODE = "SELECT * FROM barcode WHERE EANorUPC = ?;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_BARCODE);
			ps.setString(1, barcodeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String productBarcodeURL = rs.getString("productBarcodeURL");
				barcode = new Barcode(barcodeID, productBarcodeURL);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return barcode;
	}
	@Override
	public int createBarcode(Barcode barcode) {
		String SELECT_BARCODE = "INSERT INTO `barcode` VALUES (?,?);";
		int row = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_BARCODE);
			ps.setString(1, barcode.getEANorUPC());
			ps.setString(2, barcode.getProductBarcodeURL());
			row = ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public int updateBarcode(Barcode barcode) {
		String UPDATE_PRODUCT = "UPDATE barcode SET productBarcodeURL=? FROM barcode INNER JOIN product ON barcode.EANorUPC = product.EANorUPC WHERE  barcode.EANorUPC = ?; ";
		int row = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
			ps.setString(1, barcode.getProductBarcodeURL());
			ps.setString(2, barcode.getEANorUPC());
			row = ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

}
