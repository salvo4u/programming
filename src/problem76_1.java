public class problem76_1 {
	static int countCombinations(int number, int minimum) {
		int temp = 1;
		if (number <= 1)
			return 1;
		for (int i = 1; i <= number / 2; i++) {
			if (i >= minimum)
				temp = temp + countCombinations(number - i, i);

		}
		return temp;
	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		int count = countCombinations(9, 1);
		long t2 = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("TIME:" + (t2 - t1) + " millisec");
	}
}
