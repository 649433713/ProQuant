package data.spider.update;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.dao.BenchDataDao;
import PO.BenchData;
import PO.BenchDataId;

@Service("BBDUS")
public class BasicBenchDataUpdateSpider extends TimerTask implements BasicDataUpdateSpiderService {
	@Autowired
	BenchDataDao benchDataDao;
	
	public String[] URL=
		{"http://quotes.money.163.com/trade/lsjysj_",
		 ".html"};
	
	/**
		 (non-Javadoc)
	 * @see data.spider.update.BasicDataUpdateSpiderService#sharesCrawl(java.lang.String)
	 */
	@Override
	public void sharesCrawl(String code) {
		String url = URL[0]+code+URL[1];
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36 OPR/45.0.2552.812";
		try {
			Document document =  Jsoup.connect(url).header("User-Agent",userAgent).timeout(3000).get();
			Elements elements = document.select("table[class=table_bg001 border_box limit_sale]");
			Elements trs = elements.first().select("tr");
			trs.remove(0);
			BenchData benchData;
			BenchDataId benchDataId;
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Elements tds = trs.first().select("td");
			if (tds.size()!=0) {
				benchData = new BenchData();
				benchDataId = new BenchDataId();
				benchDataId.setCode(code);
				try {
					benchDataId.setDate(sf.parse(tds.get(0).text().replaceAll(",","")));
					benchDataId.setOpen(Double.parseDouble(tds.get(1).text().replaceAll(",","")));
					benchDataId.setHigh(Double.parseDouble(tds.get(2).text().replaceAll(",","")));
					benchDataId.setLow(Double.parseDouble(tds.get(3).text().replaceAll(",","")));
					benchDataId.setClose(Double.parseDouble(tds.get(4).text().replaceAll(",","")));
					benchDataId.setChange(Double.parseDouble(tds.get(5).text().replaceAll(",","")));
					benchDataId.setChg(Double.parseDouble(tds.get(6).text().replaceAll(",","")));
					benchDataId.setVolume(Double.parseDouble(tds.get(7).text().replaceAll(",","")));
					benchDataId.setTurnover(Double.parseDouble(tds.get(8).text().replaceAll(",","")));
					benchData.setId(benchDataId);
					benchDataDao.persist(benchData);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sharesCrawl(code);
		}
	}

	@Override
	public void run() {
		List<String> basicBenchCodes =  Arrays.asList("000300","399005","399006");
		for (String string : basicBenchCodes) {
			sharesCrawl(string);
		}
	}

	
}
