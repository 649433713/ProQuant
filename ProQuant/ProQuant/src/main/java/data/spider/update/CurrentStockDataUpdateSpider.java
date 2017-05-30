package data.spider.update;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("CSDUS")
public class CurrentStockDataUpdateSpider implements CurrentDataUpdateSpiderService{

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
			return;
		}
		String path = null;
		try {
			path = java.net.URLDecoder.decode(getClass().getClassLoader().getResource("").getPath().substring(1),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String command = "python "+path+"pythonSpider/getCurrentData.py";
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
