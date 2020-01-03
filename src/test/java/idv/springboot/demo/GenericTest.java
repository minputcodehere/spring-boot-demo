package idv.springboot.demo;

public class GenericTest {

	public static void main(String[] args) throws Exception {

		GenericTestBean<Boolean> Att1 = new GenericTestBean<Boolean>();

		GenericTestBean<Integer> Att2 = new GenericTestBean<Integer>();

		Att1.setAtt(new Boolean(true));
		Boolean b = Att1.getAtt(); // 不需要再轉換型態
		System.out.println(b);

		Att2.setAtt(new Integer(10));
		Integer i = Att2.getAtt(); // 不需要再轉換型態
		System.out.println(i);
	}
}
