package idv.springboot.demo.Controller.Business;

public class TreadController extends Thread {

	private int x = 0;

	public void run() {

		print();

		System.out.println("Hello I'm " + x);
	}

	public synchronized void print() {
		System.err.println("x >> " + ++x);
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new TreadController();
		Thread t2 = new TreadController();
		Thread t3 = new TreadController();
		Thread t4 = new TreadController();
		Thread t5 = new TreadController();

		// 新增 5 個 thread
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}
}
