package data.spider.update;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TimerTask;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import PO.StockCurrentData;
import net.sf.json.JSONArray;

@Service("CSDUS")
public class CurrentStockDataUpdateSpider extends TimerTask implements CurrentDataUpdateSpiderService{

	private String hs_a_url = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?num=100&node=hs_a&page=";
	private String hs_b_url = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?num=100&node=hs_b";
	private String shfxjs_url = "http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?num=100&node=shfxjs";
	
	private String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36 OPR/45.0.2552.812";

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Map<String,StockCurrentData> result;
	
	@Override
	public void updateCurrentData() {
		Calendar calendar = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 9);
		start.set(Calendar.MINUTE,15);
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 15);
		end.set(Calendar.MINUTE,0);
		
		if (calendar.before(start)||calendar.after(end)) {
			//return;
		}
		
		Document document = null;
		ArrayList<StockCurrentData> result = new ArrayList<>();
		try {
			for (int i = 1; i <33 ; i++) {
				document = Jsoup.connect(hs_a_url+i).header("User-Agent",userAgent).timeout(5000).get();
				String jsonstr = document.body().text();
				JSONArray jsonArray = JSONArray.fromObject(jsonstr);
				Collection<StockCurrentData> temp = JSONArray.toCollection(jsonArray, StockCurrentData.class);
				result.addAll(temp);
			}
			//updateByJDBC(result);
			//updateByHibernate(result);
			document = Jsoup.connect(hs_b_url).header("User-Agent",userAgent).timeout(5000).get();
			String jsonstr = document.body().text();
			JSONArray jsonArray = JSONArray.fromObject(jsonstr);
			Collection<StockCurrentData> temp = JSONArray.toCollection(jsonArray, StockCurrentData.class);
			result.addAll(temp);
			document = Jsoup.connect(shfxjs_url).header("User-Agent",userAgent).timeout(5000).get();
			jsonstr = document.body().text();
			jsonArray = JSONArray.fromObject(jsonstr);
			temp = JSONArray.toCollection(jsonArray, StockCurrentData.class);
			result.addAll(temp);

			CurrentStockDataUpdateSpider.result = result.stream().collect(Collectors.toMap(StockCurrentData::getCode,(p)->p ));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateByHibernate(ArrayList<StockCurrentData> result) {
		Session session= sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		for (StockCurrentData stockCurrentData : result) {
			stockCurrentData.setDate(new Date());
			session.merge(stockCurrentData);
		}
		transaction.commit();
		session.close();

	}
	private void updateByJDBC(ArrayList<StockCurrentData> result) {
		String updateSql = "UPDATE `stock_current_data` set `changepercent`=?,"
				+ "`trade`=?,`open`=?,`high`=?,`low`=?,`settlement`=?,`volume`=?,"
				+ "`turnoverratio`=?,`amount`=?,`per`=?,`pb`=?,`mktcap`=?,`nmc`=?"
				+ " where code =?";
		/*SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(result.toArray());
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.batchUpdate(insertSql, batch);*/
		jdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				ps.setDouble(1, result.get(i).getChangepercent());
				ps.setDouble(2, result.get(i).getTrade());
				ps.setDouble(3, result.get(i).getOpen());
				ps.setDouble(4, result.get(i).getHigh());
				ps.setDouble(5, result.get(i).getLow());
				ps.setDouble(6, result.get(i).getSettlement());
				ps.setLong(7, result.get(i).getVolume());
				ps.setDouble(8, result.get(i).getTurnoverratio());
				ps.setLong(9, result.get(i).getAmount());
				ps.setDouble(10, result.get(i).getPer());
				ps.setDouble(11, result.get(i).getPb());
				ps.setDouble(12, result.get(i).getMktcap());
				ps.setDouble(13, result.get(i).getNmc());
				ps.setString(14, result.get(i).getCode());
				
			}
			
			@Override
			public int getBatchSize() {
				return result.size();
			}
		});
	}
	public static StockCurrentData getResult(String code) {
		return result.get(code);
	}
	
	@Override
	public void run() {

		updateCurrentData();
	}

}
