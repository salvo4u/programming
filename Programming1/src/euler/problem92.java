package euler;
import java.util.HashMap;

public class problem92 {
	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

	public static void main(String args[]) {
		int limit = 10000000;
		long t1=System.currentTimeMillis();
		int count = 0;
		for (int i = 1; i <= limit; i++) {
			int number = i;
			Integer value;
			while (true) {
				int sum = 0;
				while (number != 0) {
					sum = sum + (number % 10) * (number % 10);
					number = number / 10;
				}

				value = hmap.get(sum);

				if (value != null) {
					hmap.put(i, value);
					if (value == 89)
						count++;
					break;
				}
				if (sum == 1 || sum == 89) {
					if (sum == 89)
						count++;
					hmap.put(i, sum);
					break;
				}
				number = sum;
			}
		}
		long t2=System.currentTimeMillis();
		System.out.println(count);
		System.out.println("TIME:" + (t2 - t1) + " millisec");
	}
}
