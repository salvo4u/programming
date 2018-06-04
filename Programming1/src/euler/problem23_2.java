package euler;
import java.util.ArrayList;
public class problem23_2 {
	public static boolean isAbundant(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0)
				sum += i;
		}
		if (sum > n)
			return true;
		return false;
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		double result = 0;
		int[] numbers = new int[28123];
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		for (int i = 12; i < numbers.length; i++) {
			if (isAbundant(i)) {
				abundants.add(i);
			}
		}
		int x;
		for (int i = 0; i < abundants.size(); i++) {
			for (int j = i; j < abundants.size(); j++) {
				x = abundants.get(i) + abundants.get(j);
				if (x < 28123 && numbers[x] == 0) {
					numbers[x] = 1;
				}

			}
		}
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] == 0)
				result = result + i;
		}
		long t2 = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("TIME :" + (t2 - t1) + " millisec");
	}
}