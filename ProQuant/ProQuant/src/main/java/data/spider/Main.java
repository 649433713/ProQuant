package data.spider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		BasicBenchDataSpider basicBenchDataSpider = new BasicBenchDataSpider();
		List<String> basicBenchCodes =  Arrays.asList("000300","399005","399006");
		for (String string : basicBenchCodes) {
			basicBenchDataSpider.test(string, 2008, 2017);
		}
	}
}
