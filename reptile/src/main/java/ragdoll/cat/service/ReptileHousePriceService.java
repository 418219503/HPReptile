package ragdoll.cat.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import ragdoll.cat.model.Const;
import ragdoll.cat.model.HousePriceModel;
import ragdoll.cat.utils.FileUtil;
import ragdoll.cat.utils.HrefUtil;
import ragdoll.cat.utils.ParseUtil;

public class ReptileHousePriceService {

	public void getHousePrice(String[] citys) {		
		for(int i = 0; i < Const.CITY_NAME.length; ++i)
		{
			System.out.println("获取" + Const.CITY_NAME[i] + "房价信息...");
			List<HousePriceModel> housePriceModels = new ArrayList<HousePriceModel>();
			for(int j = 0; j < Const.YEAR.length; ++j) {
				Document doc = HrefUtil.getHref(Const.CITY_NAME[i],Const.YEAR[j]);
				HousePriceModel priceInfo = ParseUtil.getPriceInfo(doc,Const.CITY_NAME[j]);
				housePriceModels.add(priceInfo);
			}
			
			String[] city = Const.CITY_NAME[i].split(":");
			String fileName = city[1] + ".txt";
			System.out.println("正在写入文件:" + fileName + "中...");
			
			FileUtil.writeToFile(fileName, housePriceModels);		
		}
	}
}
