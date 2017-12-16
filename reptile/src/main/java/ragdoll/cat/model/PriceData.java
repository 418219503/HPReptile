package ragdoll.cat.model;

public class PriceData {
	public String time;
	public String price;
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[time=" + time + ", price=" + price + "]";
	}
}
