package random;

class MyThread1 implements Runnable {
	Integer i1, i2;
	public MyThread1(Integer i1, Integer i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	public void method1() {
		synchronized (i1) {
			System.out.println("method 1 I1 LOCKED");
			synchronized (i2) {
				System.out.println("method 1 I2 LOCKED");
			}
		}
	}

	@Override
	public void run() {
		method1();
	}
}

class MyThread2 implements Runnable {
	Integer i1, i2;
	public MyThread2(Integer i1, Integer i2) {
		this.i1 = i1;
		this.i2 = i2;
	}
	public void method1() {
		synchronized (i2) {
			System.out.println("method 2 I2 LOCKED");
			synchronized (i1) {
				System.out.println("method 2 I1 LOCKED");
			}
		}
	}

	@Override
	public void run() {
		method1();
	}
}

public class DeadLockThread {
	public static void main(String args[]) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(11);

		MyThread1 mt1 = new MyThread1(i1, i2);
		MyThread2 mt2 = new MyThread2(i1, i2);

		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);

		t1.start();
		t2.start();
	}
}