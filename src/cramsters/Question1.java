package cramsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Question1 {
	public static void primeFactors(int number) {
		if (number == 1 || number == 0) {
			System.out.println(number + " is neither prime nor composite.");
			return;
		}
		int i = 2, n = number;
		Set<Integer> factors = new HashSet<Integer>();
		while (n > 1) {
			if (n % i == 0) {
				n /= (i);
				factors.add(i);
			}
			else
				i++;
			
		}

		if (factors.size() > 1)
			System.out.println(number + " is not prime. Prime Factors are: "
					+ factors);
		else
			System.out.println(number + " is a prime number");
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a positive number:");
		String s = br.readLine();
		int number = new Integer(s);
		primeFactors(number);
		br.close();
	}
}
