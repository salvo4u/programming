package euler;
import java.util.ArrayList;
import java.util.HashMap;

public class problem122 {
	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

	public static int minMultipliers(int x, int min) {
		Integer freq = hmap.get(x);
		if (freq != null)
			return freq;
		if (x == 2)
			return 1;
		if (x == 3)
			return 2;
		
		ArrayList<Integer> vlist = new ArrayList<Integer>();
		int limit = 1;
		if (x % 2 == 0)
			limit = x / 2;
		else
			limit = x / 2 + 1;
	
		for (int i = x - 1; i >= limit; i--) {
			int c1 = minMultipliers(i, min) + 1;
			System.out.println(x + "  " + i + "   " + c1 + "  " + min);
			if (c1 < min)
				min = c1;
		}
		hmap.put(x, min);
		return min;
	}

	public static void main(String args[]) {
		int c = minMultipliers(15, Integer.MAX_VALUE);
		System.out.println(hmap);
		System.out.println(c);
	}
}
