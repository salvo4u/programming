package interviewstreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;

public class LuckyNumber {
	public static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static TreeMap<String, Boolean> ansmap = new TreeMap<String, Boolean>();

	public static BigInteger A,B;

	public static int Alength, Blength;

	public static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static int count = 0;

	public static void partition(int n, int max, String temp,
			ArrayList<ArrayList<Integer>> master, ArrayList<Integer> holder) {
		if (n == 0) {
			//System.out.println(holder);
			Integer squaresum = 0;
			String digits = "";
			for (Integer integer : holder) {
				squaresum += integer * integer;
				digits = integer.toString() + "" + digits;
			}
			if (holder.size() >= Alength && holder.size() <= Blength) {
				BigInteger number = new BigInteger(digits);
				BigInteger n1=number.max(A);
				BigInteger n2=number.max(B);// System.out.println(digits + "  " + squaresum + "  " +holder);
				if (primes.contains(squaresum)) {
					if (n1.toString().equals(number.toString()) && n2.toString().equals(B.toString())){
							//System.out.println(digits + "  " + squaresum + "  "	+ holder);
						if (ansmap.get(digits) == null) {
							ansmap.put(digits, true);
							count++;
						}
					}
				}
			} else {
				int numberzeros = Alength - holder.size();
				for (int i = 0; i < numberzeros; i++)
					digits += "0";

				permuteString("", digits);
			}
		}

		int res = Math.min(max, n);
		if (res > 9)
			return;

		for (int i = res; i >= 1; i--) {
			holder.add(i);
			partition(n - i, i, temp + " " + i, master, holder);
			holder.remove(holder.size() - 1);
		}
	}

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			String s = beginningString + endingString;
			BigInteger number = new BigInteger(s);
			BigInteger n1=number.max(A);
			BigInteger n2=number.max(B);
			
			if (n1.toString().equals(number.toString()) && n2.toString().equals(B.toString())){
				if (ansmap.get(s) == null) {
					ansmap.put(s, true);
					count++;
				}
			}
		} else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i)
							+ endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i),
							newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

	public static void main(String args[]) throws IOException {
		primes.add(2);
		for (int i = 3; i <= 81 * 18; i = i + 2) {
			if (isPrime(i))
				primes.add(i);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Integer n = new Integer(s);
		for (int i1 = 0; i1 < n; i1++) {
			s = br.readLine();
			A = new BigInteger(s.split(" ")[0]);
			B = new BigInteger(s.split(" ")[1]);

			Alength = A.toString().length();
			Blength = B.toString().length();

			ansmap.clear();
			int i = 0;
			while (true) {
				int prime = primes.get(i++);
				if (prime > Blength * 81)
					break;
				ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> holder = new ArrayList<Integer>();
				partition(prime, prime, "", master, holder);
			}
			System.out.println(count);
			count = 0;
		}
	}
}
