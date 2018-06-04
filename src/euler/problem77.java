package euler;
import java.util.ArrayList;

public class problem77 {
	static boolean isPrime(int n) {
		if (n == 1)
			return false;
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0)
				return false;
		}
		return true;
	}

	static int countCombinations(int number, int minimum) {
		int temp = 1;

		if (number <= 1)
			return 1;
		// System.out.print("\n"+number+"---->");
		for (int i = 1; i <= number / 2; i++) {
			if (i >= minimum) {
				temp = temp + countCombinations(number - i, i);
				// System.out.println("Here"+" "+i);
			}
		}
		return temp;
	}

	public static void main(String args[]) {
		int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79};
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<primes.length;i++)
		{
			while(true)
			{
				
			}
		}
	}
}
