package idv.springboot.demo;

public class InvokeTest {

	public static void main(String[] args) throws Exception {

		GenericTest<Boolean> Att1 = new GenericTest<Boolean>();

		GenericTest<Integer> Att2 = new GenericTest<Integer>();

		Att1.setAtt(new Boolean(true));
		Boolean b = Att1.getAtt(); // 不需要再轉換型態
		System.out.println(b);

		Att2.setAtt(new Integer(10));
		Integer i = Att2.getAtt(); // 不需要再轉換型態
		System.out.println(i);
	}

}
