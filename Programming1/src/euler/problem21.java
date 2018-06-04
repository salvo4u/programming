package euler;
import java.util.ArrayList;
import java.util.List;

public class problem21 {
	public static int isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return i;
		}
		return 0;
	}

	static List<Integer> list = new ArrayList<Integer>();

	static int getvalue(int num) {
		if (isPrime(num) == 0)
			return 1;
		int value = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				value = value + i;
		}
		return value;
	}

	public static void main(String args[]) {
		int n = 10000, sum = 0;
		for (int i = 2; i < n; i++) {
			int val = getvalue(i);
			int revval = getvalue(val);
			if (i == revval && val != i)
				sum = sum + revval;
		}
		System.out.println(sum);
	}
}
