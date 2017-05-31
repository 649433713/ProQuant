package dataTest;

import java.util.Date;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import PO.StockData;
import dataservice.StockDataService;

public class StockDataServiceTest {

	private static StockDataService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		service = (StockDataService) context.getBean("StockDataService");
	}

	@Test
	public void test() {
		Map<Date,StockData> result = service.getBasicDateStock(null, 100, "000050");
		
		System.out.println(result);
	}

}
