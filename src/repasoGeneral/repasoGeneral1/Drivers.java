package repasoGeneral.repasoGeneral1;

public class Drivers {
	
	private String country;
	private int count;
	
	
	public Drivers(String country, int count) {
		this.country = country;
		this.count = count;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Drivers [country=" + country + ", count=" + count + "]";
	}
	
}
