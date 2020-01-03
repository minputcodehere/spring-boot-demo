package idv.springboot.demo;

import java.lang.reflect.Method;

public class InvokeTest {

	public static void main(String[] args) throws Exception {

		Class c = Class.forName("idv.springboot.demo.TestBean");
		// 使用無參數建構方法建立物件
		Object targetObj = c.newInstance();
		// 設定參數型態
		Class[] param1 = { String.class };
		// 根據參數型態取回方法物件
		Method setNameMethod = c.getMethod("setName", param1);
		// 設定引數值
		Object[] argObjs1 = { "caterpillar" };
		// 給定引數呼叫指定物件之方法
		setNameMethod.invoke(targetObj, argObjs1);

		Class[] param2 = { Integer.TYPE };
		Method setScoreMethod = c.getMethod("setId", param2);

		Object[] argObjs2 = { new Integer(90) };
		setScoreMethod.invoke(targetObj, argObjs2);
		// 顯示物件描述
		System.out.println(targetObj);
	}

}
