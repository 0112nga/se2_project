package IDAO;

import Models.Barcode;

public interface IBarcodeDAO {
	Barcode getBarcode(String EANorUPC);

	int createBarcode(Barcode barcode);

	int updateBarcode(Barcode barcode);
}
