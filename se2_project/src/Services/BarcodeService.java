package Services;

import DAO.BarcodeDAO;
import IDAO.IBarcodeDAO;
import Models.Barcode;

public class BarcodeService {
	private static BarcodeService service;
	private IBarcodeDAO barcodeDAO;
	
	private BarcodeService() {
		super();
		barcodeDAO = new BarcodeDAO();
	}
	public static BarcodeService getBarcodeService() {
		if(service == null) {
			service = new BarcodeService();
		}
		return service;
	}
	public Barcode getBarcode(String barcodeID) {
		return barcodeDAO.getBarcode(barcodeID);
	}
	public int createBarcode(Barcode barcode) {
		return barcodeDAO.createBarcode(barcode);
	}
	public int updateBarcode(Barcode barcode) {
		return barcodeDAO.updateBarcode(barcode);
		
	}
}
