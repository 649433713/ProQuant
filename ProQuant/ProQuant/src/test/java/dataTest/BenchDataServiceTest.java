package dataTest;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dataservice.BenchDataService;
import model.StockPlate;

public class BenchDataServiceTest {

	private static BenchDataService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		service = (BenchDataService) context.getBean("BenchDataService");
	}


	/*@Test
	public void testGetStocksByDateAndPlate() {
		Map<Date,BenchData> map = service.getDataByNumAndPlate(null, 100, StockPlate.CSI300);
		
		System.out.println(map);
	}

	@Test
	public void testGetBenchCurrentData() {
		
		BenchCurrentData benchData = service.getBenchCurrentData(StockPlate.CHINEXT);
		System.out.println(benchData);
	}*/

	@Test
	public void testGetStockListOfBench(){
		List<String> result = service.getStockListOdBench(StockPlate.SME);
		List<String> result2 = service.getStockListOdBench(StockPlate.CHINEXT);
		System.out.println(result);
		System.out.println(result2);
	}
}
