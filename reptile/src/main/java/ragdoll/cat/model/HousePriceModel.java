package ragdoll.cat.model;

import java.util.ArrayList;
import java.util.List;

public class HousePriceModel {
	public String city;
	public List<PriceData> info;

	public HousePriceModel(){
		info = new ArrayList<PriceData>();
	}
	
	public List<PriceData> getInfo() {
		return info;
	}

	public void setInfo(List<PriceData> info) {
		this.info = info;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[city=" + city + ", info=" + info + "]";
	}
}
