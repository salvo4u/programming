import java.util.ArrayList;

public class problem23_1 {
	public static boolean isAbundant(int number) {
		int sum = 0;
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0)
				sum += i;
		}
		if (sum > number)
			return true;
		return false;
	}

	static int arr[] = new int[28123];

	public static void main(String args[]) {
		int sum = 0;
		for (int j = 12; j < 28123; j++) {
			if (isAbundant(j)) {
				int pos = 1;
				int x = 1;
				while (x <= 28123) {
					x = j * pos;
					pos++;
					if (x < 28123 && arr[x] == 0)
						arr[x] = 1;
				}
			}
		}
		sum = 0;
		for (int j = 12; j < 28123; j++) {
			System.out.println(arr[j] + "  " + j);
			if (arr[j] == 0)
				sum = sum + j;
		}
		System.out.println(sum);
	}
}
