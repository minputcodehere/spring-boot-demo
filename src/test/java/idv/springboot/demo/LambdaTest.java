package idv.springboot.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

	public static void main(String[] args) throws Exception {

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("5");
		list.add("4");
		List<String> list2 = list.stream().filter(s -> Integer.valueOf(s) < 3).collect(Collectors.toList());
		list2.add("7");
		list2.forEach(s -> System.out.print(s));
	}
}
