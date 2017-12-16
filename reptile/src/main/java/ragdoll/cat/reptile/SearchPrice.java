package ragdoll.cat.reptile;

import java.util.List;

import ragdoll.cat.model.Const;
import ragdoll.cat.model.HousePriceModel;
import ragdoll.cat.service.ReptileHousePriceService;

public class SearchPrice {
	
	public static void main(String[] args) {
		System.out.println("开始爬取数据，丽丽喝口水，等等就好哟~");
		ReptileHousePriceService service = new ReptileHousePriceService();
		System.out.println("一共:" + (Const.CITY_NAME.length * Const.YEAR.length) + "个搜索目标...");
		List<HousePriceModel> housePriceModels = service.getHousePrice(Const.CITY_NAME);
		
		for (HousePriceModel housePriceModel : housePriceModels) {
			System.out.println(housePriceModel);
		}
		
		System.out.println("爬取完毕，请丽丽查收，时间太久也没办法，略略略...");
		System.out.println("PS:有些城市很久以前就没有房价记录了，没有记录的都表示为null...");
	}
}
