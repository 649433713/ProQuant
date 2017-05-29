package data.spider.update;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExecuteUpdate {

	public static void main(String[] args) {
		ExecuteUpdate executeUpdate;
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-context.xml");
		executeUpdate = context.getBean(ExecuteUpdate.class);
		executeUpdate.start();
	}
}
