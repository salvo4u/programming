public class problem2 {
	public static void main(String rgp[]) {
		int a = 1, b = 2;
		int sum = 2;
		while (true) {
			int c = a + b;
			a = b;
			b = c;
			if (c > 4000000)
				break;

			if (c % 2 == 0)
				sum = sum + c;
		}
		System.out.println(sum);
	}
}
