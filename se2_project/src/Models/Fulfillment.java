package Models;

import utils.DomainConstraint;

public class Fulfillment {
	private int fulfillment_key;
	private String email;
	private String companyName;
	private String currency;
	private double landingCost;
	private String phoneNumber;
	private Location location;
	
	public Fulfillment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Fulfillment(int fulfillment_key, String email, String companyName, String currency, double landingCost,
			String phoneNumber, Location location) {
		super();
		this.fulfillment_key = fulfillment_key;
		this.email = email;
		this.companyName = companyName;
		this.currency = currency;
		this.landingCost = landingCost;
		this.phoneNumber = phoneNumber;
		this.location = location;
	}



	public int getFulfillment_key() {
		return fulfillment_key;
	}
	
	public void setFulfillment_key(int fulfillment_key) {
		this.fulfillment_key = fulfillment_key;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getLandingCost() {
		return landingCost;
	}

	public void setLandingCost(double landingCost) {
		this.landingCost = landingCost;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Fulfillment [fulfillment_key=" + fulfillment_key + ", email=" + email + ", companyName=" + companyName
				+ ", currency=" + currency + ", landingCost=" + landingCost
				+ ", phoneNumber=" + phoneNumber + ", locationID=" + location + "]";
	}
	
}
