package data.spider.update;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimerTask;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.dao.StockDataDao;
import PO.StockData;
import PO.StockDataId;

@Service("BSDUS")
public class BasicStockDataUpdateSpider extends TimerTask implements BasicDataUpdateSpiderService {

	@Autowired
	StockDataDao stockDataDao;
	@Autowired
	SessionFactory sessionFactory;
	
	public String[] URL=
		{"http://quotes.money.163.com/trade/lsjysj_",
		 ".html"};
	@Override
	public void sharesCrawl(String code) {
		String url = URL[0]+code+URL[1];
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36 OPR/45.0.2552.812";
		try {
			Document document =  Jsoup.connect(url).header("User-Agent",userAgent).timeout(3000).get();
			Elements elements = document.select("table[class=table_bg001 border_box limit_sale]");
			Elements trs = elements.first().select("tr");
			trs.remove(0);
			StockData stockData;
			StockDataId stockDataId;
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Elements tds = trs.first().select("td");

			if (tds.size()!=0) {
				stockData = new StockData();
				stockDataId = new StockDataId();
				stockDataId.setCode(code);
				try {
					stockDataId.setDate(sf.parse(tds.get(0).text().replaceAll(",","")));
					stockDataId.setOpen(Double.parseDouble(tds.get(1).text().replaceAll(",","")));
					stockDataId.setHigh(Double.parseDouble(tds.get(2).text().replaceAll(",","")));
					stockDataId.setLow(Double.parseDouble(tds.get(3).text().replaceAll(",","")));
					stockDataId.setClose(Double.parseDouble(tds.get(4).text().replaceAll(",","")));
					stockDataId.setChange(Double.parseDouble(tds.get(5).text().replaceAll(",","")));
					stockDataId.setChg(Double.parseDouble(tds.get(6).text().replaceAll(",","")));
					stockDataId.setVolume(Double.parseDouble(tds.get(7).text().replaceAll(",","")));
					stockDataId.setTurnover(Double.parseDouble(tds.get(8).text().replaceAll(",","")));
					stockDataId.setAmplitude(Double.parseDouble(tds.get(9).text().replaceAll(",","")));
					stockDataId.setTurnoverRatio(Double.parseDouble(tds.get(10).text().replaceAll(",","")));
					stockData.setId(stockDataId);
					stockDataDao.persist(stockData);
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
		Session session= sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Object[]> list = session.createQuery("select I.id,I.code from InfoData I ").list();
		for (Object[] objects : list) {
			System.out.println("now id = "+objects[0]);
			sharesCrawl((String) objects[1]);
		}
		session.close();
	}

}
