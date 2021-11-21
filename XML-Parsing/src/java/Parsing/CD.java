package Parsing;

public class CD {

	private String title;
	private String artist;
	private String country;
	private String company;
	private String price;
	private String year;

	public CD() {
		this.title = null;
		this.artist = null;
		this.country = null;
		this.company = null;
		this.price = null;
		this.year = null;
	}

	public void setTitile(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitile() {
		return this.title;
	}

	public String getArtist() {
		return this.artist;
	}

	public String getCountry() {
		return this.country;
	}

	public String getCompany() {
		return this.company;
	}

	public String getPrice() {
		return this.price;
	}

	public String getYear() {
		return this.year;
	}

}