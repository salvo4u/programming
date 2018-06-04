package random;

public class Common {

	public synchronized void synchronizedMethod1() {
		System.out.println("synchronizedMethod1 called");
		System.out.println("Executed by:"+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod1 done");
	}
	public synchronized void synchronizedMethod2() {
		System.out.println("synchronizedMethod2 called");
		System.out.println("Executed by:"+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod2 done");
	}

	public void method1() {
		System.out.println("Method 1 called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 done");
	}
}
