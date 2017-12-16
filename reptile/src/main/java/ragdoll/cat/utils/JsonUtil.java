package ragdoll.cat.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import ragdoll.cat.model.HousePriceModel;
import ragdoll.cat.model.PriceData;

public class JsonUtil {

	public static String objectToJson(HousePriceModel housePriceModel) {
		if(housePriceModel == null)
		{
			return "";
		}
		
		JSONObject jsonObject = new JSONObject();
	
		List<String> time = new ArrayList<String>();
		List<String> price = new ArrayList<String>();
		List<PriceData> priceDatas = housePriceModel.getInfo();
		
		for (PriceData priceData : priceDatas) {
			time.add(priceData.getTime());
			price.add(priceData.getPrice());
		}
		
		//jsonObject.put("year", year);
		jsonObject.put("time", time);
		jsonObject.put("price", price);
		
		return jsonObject.toString();
	}
}
