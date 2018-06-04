public class problem78 {

	static int countCombinations(int number, int minimum) {
		int temp = 0;
		if (number <= 1)
			return 1;

		for (int i = 1; i <= number / 2; i++) {
			if (i >= minimum)
				temp = temp + countCombinations(number - i, i);

		}
		return temp + 1;
	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		int count, N = 70;
		for (N = 1; N <= 100; N++) {
			count = countCombinations(N, 1);
			System.out.println(N + " -->  " + count);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME:" + (t2 - t1) + " millisec");
	}

}
