package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GCD {
	public static void gcd(int a, int b) {
		if (b == 0) {
			System.out.println(a);
			return;
		}
		gcd(b, a % b);
	}

	public static List<Integer> list = new ArrayList<Integer>();
	public static List<Integer> locallist = new ArrayList<Integer>();

	public static int kadanes(int arr[]) {
		int currsum = 0, maxsum = 0;
		for (int i = 0; i < arr.length; i++) {
			currsum = currsum + arr[i];
			if (currsum > maxsum)
				maxsum = currsum;

			if (arr[i] < 0)
				currsum = 0;

		}
		return maxsum;
	}
	static HashMap<Integer, Integer> hmap=new HashMap<Integer,Integer>();
	public static int catalanNumber(int n) {
		if (n == 1||n==0)
			return 1;
		if (n == 2)
			return 2;
		if(hmap.containsKey(n))
			return hmap.get(n);
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum = sum + catalanNumber(i) * catalanNumber(n - i - 1);
		hmap.put(n,sum);
		return sum;
	}
	public static void main(String args[]) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split(" ");
		int a = new Integer(arr[0]);
		int b = new Integer(arr[1]);
		int arr1[] = { 1, 3, -5, 15, 1, 11, -15, 18 };
		System.out.println(kadanes(arr1));
		System.out.println(list);*/
		System.out.println(catalanNumber(10));
	}
}
