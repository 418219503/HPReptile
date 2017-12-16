package ragdoll.cat.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import ragdoll.cat.model.Const;

public class HrefUtil {
	
	public static Document getHref(String city,String year) {
		Document document = null;
		String[] c = city.split(":");
		city = c[0];
		String url = Const.REPTILE_URL.replace("#city#", city).replace("#year#", year);
		System.out.println("抓取网页" + url + "中...");
		try {
			document = Jsoup
					.connect(url)
					.header("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
					.header("Accept-Encoding", "gzip, deflate,sdch")
					.header("Accept-Language",
							"zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.header("Referer", url)
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36")
					.timeout(5000).get();
		} catch (IOException e) {
			System.out.println("connect error...");
		}
		
		return document;
	}
}
