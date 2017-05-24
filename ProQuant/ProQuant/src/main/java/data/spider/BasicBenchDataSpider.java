package data.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BasicBenchDataSpider {
	public static final String[] URL=
		{"http://quotes.money.163.com/trade/lsjysj_zhishu_",
		 ".html?year=",
		 "&season="};
	
	public void test(String code,int start,int end) {
		for(int i=start;i<=end;i++){
			System.out.println(i+" is going");
			for (int j = 1; j < 5; j++) {
				sharesCrawl(code, i, j);
			}
		}
	}
	
	public void sharesCrawl(String code,int year,int season) {
		String url = URL[0]+code+URL[1]+year+URL[2]+season;
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36 OPR/45.0.2552.812";
		try {
			Document document =  Jsoup.connect(url).header("User-Agent",userAgent).timeout(3000).get();
			Elements elements = document.select("table[class=table_bg001 border_box limit_sale]");
			Elements trs = elements.first().select("tr");
			for (Element tr : trs) {
				Elements tds = trs.select("td");
				System.out.println("======");
				for (Element td : tds) {
					String text = td.text();
					if (text!=null&&text.length()!=0) {
						System.out.print(text.replace(',',' '));
							
					}
				}
				System.out.println("======");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sharesCrawl(code,year,season);
		}
	}
	
	public static void main(String[] args) {
		new BasicBenchDataSpider().test("399005", 2017, 2017);
	}
}
