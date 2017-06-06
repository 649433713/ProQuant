package dataTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dataservice.UserTradeService;

public class UserTradeServiceTest {

	private static UserTradeService userTradeService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		userTradeService = (UserTradeService) context.getBean("UserTradeService");
		
	}


	@Test
	public void test() {
		System.out.println(userTradeService.buy("yinywf", "603999", 1000));;
	}

}
