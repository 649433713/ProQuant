package dataTest.spiderTest;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dataservice.KLineDataService;
public class KLineDataServiceTest {

	private static KLineDataService klineDataService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		klineDataService = (KLineDataService) context.getBean("KLineDataService");
	}

	@Test
	public void test() {
		List result = klineDataService.getdayLine("000001", null, 0, false);
		
		System.out.println(result.size());
	}

}
