package euler;

import java.util.HashMap;

public class problem74_2 {

	static HashMap<Integer, Integer> gm = new HashMap<Integer, Integer>();
	static int fact[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	static int breakUp(Integer number, HashMap<Integer, Integer> hm, int length) {
		char arr[] = number.toString().toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum = sum + fact[(int) arr[i] - 48];
		if (hm.get(sum) != null) {
			int x = hm.get(sum);
			return length + 1;
		} else {
			hm.put(sum, length + 1);
			return breakUp(sum, hm, length + 1);
		}
	}
	public static void main(String args[]) {
		int N1 = 69, N2 = 999999;
		int count = 0;
		long t1 = System.currentTimeMillis();
		for (Integer i = N1; i <= N2; i++) {
				HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
				hm.put(i, 0);
				int y = breakUp(i, hm, 0);
			if (y == 60) 
				count++;
		}
		long t2 = System.currentTimeMillis();
		System.out.println(count + " \nTIME:" + (t2 - t1)+"(millisec)");
	}
}
