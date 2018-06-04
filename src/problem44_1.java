
import java.util.Vector;

public class problem44_1 {
	public static void main(String args[]) {
		Vector<Long> v = new Vector<Long>();
		int i = 0;
		int flag = 0;
		while (true) {
			i++;
			long number1 = i * (3 * i - 1) / 2;
			for (int j = 0; j < v.size(); j++) {
				long number2 = v.get(j);
				long diff = Math.abs(number2 - number1);
				long sum = number1 + number2;
				double ks = (1 + Math.sqrt(1 + 24 * sum)) / 6;
				double kd = (1 + Math.sqrt(1 + 24 * diff)) / 6;

				if (kd - (int) kd == 0) {
					if (ks - (int) ks == 0) {
						System.out.println(diff);
						flag = 1;
						break;
					}
				}
			}
			if (flag == 1)
				break;
			v.add(number1);
		}
	}
}
