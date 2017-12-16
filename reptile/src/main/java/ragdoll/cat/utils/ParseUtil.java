package ragdoll.cat.utils;

import org.jsoup.nodes.Document;

import ragdoll.cat.model.HousePriceModel;
import ragdoll.cat.model.PriceData;

public class ParseUtil {
	
	public static HousePriceModel getPriceInfo(Document document,String city){
		HousePriceModel housePriceModel = new HousePriceModel();
		String[] c = city.split(":");
		city = c[1];
		housePriceModel.setCity(city);
		
		int start = document.toString().indexOf("window.drawChart");
		if(start == -1)
			return null;
		String target = document.toString().substring(start);
		int end = target.indexOf("});");
		target = target.substring(0, end);
		
		String[] price = ParseUtil.getPrices(target);
		String[] time = ParseUtil.getTime(target);
		
		for(int i = 0;i < price.length; ++i)
		{
			PriceData priceData = new PriceData();
			priceData.setPrice(price[i]);
			priceData.setTime(time[i]);
			housePriceModel.getInfo().add(priceData);
		}
		
		return housePriceModel;	
	}
	
	public static String[] getPrices(String target) {
		String[] price;
		int start;
		int end;
		
		start = target.indexOf("ydata");
		target = target.substring(start);
		start = target.indexOf("\"data\":");
		end = target.indexOf("}]");
		target = target.substring(start+"\"data\":[".length(), end);
		price = target.split(",");
		
		return price;
	}
	
	public static String[] getTime(String target) {
		String[] time = null;
		int start;
		int end;
		
		start = target.indexOf("xyear");
		target = target.substring(start);
		end = target.indexOf("},");
		target = target.substring("xyear:{".length(), end);

		String[] timePart = target.split(",");
		time = new String[timePart.length];
		
		for (int i = 0; i < timePart.length; ++i) {
			String[] timeZone = timePart[i].split(":");
			String month = dealWithString(timeZone[0]);
			String year = dealWithString(timeZone[1]);
			time[i] = year + month;
		}
		
		return time;	
	}
	
	public static String dealWithString(String str) 
	{
		String result = str;
		int start = result.indexOf("\"");
		result = result.substring(start + 1);
		int end = result.indexOf("\"");
		result = result.substring(0, end);
		
		return result;
	}
}
