public class problem12 {
	public static void main(String args[]) {
		for (int i = 10;; i++) {
			int n = i * (i + 1) / 2;
			int count = 2;
			for (int k = 2; k * k <= n; k++) {
				if (n % k == 0)
					count += 2;
			}
			if (count >= 500) {
				System.out.println(n);
				break;
			}
		}
	}
}