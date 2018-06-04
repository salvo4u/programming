package interviewstreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Equations1 {
	public static boolean isPrime(double num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static ArrayList<Integer> primes = new ArrayList<Integer>();

	/*
	 * public static long getNumberofEquations(int N) { }
	 */

	public static void main(String args[]) throws IOException {
		// 32327
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = new Integer(s);

		// Generate Primes
		primes.add(2);
		for (int i = 3; i <= N; i = i + 2) {
			if (isPrime(i))
				primes.add(i);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		long possi = 1;
		for (int i = 0; i < primes.size(); i++) {
			long prime = primes.get(i);
			int k = 0;
				int power = 1;
				while (true) {
					long number = (long) Math.pow(prime, power++);
					if (N / number < 1)
					{
						break;
					}
					k = (int) (k + (N / number));
				}
				if (k > 0)
					list.add(k);
			
			if(k>0)
			possi = ((possi%1000007) * (2*k+1))%1000007;
		}
	System.out.println(possi);
	}
}
