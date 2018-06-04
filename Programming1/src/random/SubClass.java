package random;

class T implements Runnable {
	SuperClass s;

	T(SuperClass s) {
		this.s = s;
	}

	@Override
	public void run() {
		s.doSomethingDangerous();
	}
}

abstract class SuperClass {
	public SuperClass() {
		new Thread(new T(this)).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) { /* ignore */
		}
	}

	public abstract void doSomethingDangerous();

}

public class SubClass extends SuperClass {
	int number;
	public SubClass() {
		super();
		number = 2;
	}
	public synchronized void doSomethingDangerous() {
		if (number == 2) {
			System.out.println("everything OK");
		} else {
			System.out.println("we have a problem.");
		}
	}
	public static void main(String args[]) {
		new SubClass();
	}
}