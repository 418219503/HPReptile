package ragdoll.cat.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import ragdoll.cat.model.Const;
import ragdoll.cat.model.HousePriceModel;
import ragdoll.cat.utils.HrefUtil;
import ragdoll.cat.utils.ParseUtil;

public class ReptileHousePriceService {

	public List<HousePriceModel> getHousePrice(String[] citys) {	
		List<HousePriceModel> housePriceModels = new ArrayList<HousePriceModel>();
		
		for(int i = 0; i < Const.YEAR.length; ++i)
		{
			System.out.println("获取" + Const.YEAR[i] + "年房价信息...");
			for(int j = 0; j < Const.CITY_NAME.length; ++j) {
				Document doc = HrefUtil.getHref(Const.CITY_NAME[j],Const.YEAR[i]);
				HousePriceModel priceInfo = ParseUtil.getPriceInfo(doc,Const.CITY_NAME[j]);
				housePriceModels.add(priceInfo);
			}
		}
		return housePriceModels;
	}
}
