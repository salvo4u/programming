package random;

class Spoon {
	private Diner owner;
	public Spoon(Diner d) {
		owner = d;
	}
	public Diner getOwner() {
		return owner;
	}
	public synchronized void setOwner(Diner d) {
		owner = d;
	}
	public synchronized void use() {
		System.out.printf("%s has eaten!", owner.name);
	}
}

class Diner {
	String name;
	boolean iamhungry = true;

	Diner(String spouseName) {
		this.name = spouseName;
	}

	void dinesWith(Diner spouse, Spoon spoon) {
		while (iamhungry) {
			if (spoon.getOwner() != this) {
				try {
					Thread.sleep(1000);
					continue;
				} catch (InterruptedException e) {
					e.printStackTrace();
					continue;
				}
			}
			if (spouse.iamhungry) {
				spoon.setOwner(spouse);
				System.out.println("YOU EAT DARLING:" + spouse.name);
				continue;
			}
			spoon.use();
			iamhungry = false;
			System.out.println("I AM DONE DARLING:" + name);
			spoon.setOwner(spouse);
		}
	}
}

public class LiveLock {
	public static void main(String at[]) {
		final Diner husband = new Diner("H");
		final Diner wife = new Diner("W");
		final Spoon spoon = new Spoon(wife);
		new Thread(new Runnable() {
			@Override
			public void run() {
				husband.dinesWith(wife, spoon);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				wife.dinesWith(husband, spoon);
			}
		}).start();
	}
}
