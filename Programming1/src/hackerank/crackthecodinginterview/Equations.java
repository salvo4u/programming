package hackerank.crackthecodinginterview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class Equations {
	public static boolean isPrime(double num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static TreeMap<Integer, Integer> hmap = new TreeMap<Integer, Integer>();

	/*
	 * public static long getNumberofEquations(int N) { }
	 */
	public static void main(String args[]) throws IOException {
		//32327
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = new Integer(s);
		
		primes.add(2);
		for (int i = 3; i <= n; i = i + 2) {
			if (isPrime(i))
				primes.add(i);
		}
		int num;
		double possibilities = 1;
		// Now break N into its power form
		for (int i = 2; i <= n; i++) {
			int j = 0;
			num = i;
			while (true) {
				int count = 0;
				int prime = primes.get(j++);
				while (num % prime == 0 && num != 0) {
					num = num / prime;
					count++;
				}
				Integer val = hmap.get(prime);
				if (val == null)
					hmap.put(prime, count);
				else
					hmap.put(prime, count + val);

				if (prime >=  i || j==primes.size())
					break;
			}
		}
		System.out.println(hmap);
		for (Iterator iterator = hmap.keySet().iterator(); iterator.hasNext();) {
			Integer prime = (Integer) iterator.next();
			int power = hmap.get(prime);
			possibilities = (possibilities%1000007 *(power+1))%1000007;
			System.out.println(prime+"  "+power+"  "+possibilities);
		}
		
		//System.out.println(nmap);
		System.out.println(possibilities%1000007);
	
	}
}
