package data.spider.update;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import PO.StockCurrentData;

@Component("CSUU")
public class CurrentStockUpdateUtils {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void updateByHibernate(ArrayList<StockCurrentData> result) {
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
	@Transactional("JDBC")
	public void updateByJDBC(ArrayList<StockCurrentData> result) {
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
}
