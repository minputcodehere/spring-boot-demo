package idv.springboot.demo;

import org.junit.jupiter.api.Test;

class ThreadTest extends Thread {

	private String x;

	@Test
	void test() {

		try {

			System.err.println("start");

			Thread t1 = new ThreadTest();
			Thread t2 = new ThreadTest();
			Thread t3 = new ThreadTest();
			Thread t4 = new ThreadTest();
			Thread t5 = new ThreadTest();

			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();

			System.err.println("end");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public ThreadTest() {

	}

	public void run() {
		System.out.println("Hello I'm " + x);
	}

}
