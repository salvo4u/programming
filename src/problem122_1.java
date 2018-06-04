import java.util.ArrayList;
import java.util.HashMap;
public class problem122_1 {
	static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	static int n = 15;

	public static int minMultipliers(int x) {
		Integer freq = hmap.get(x);
		if (freq != null)
			return freq;

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		int l = 1;
		if (x % 2 == 0)
			l = x / 2;
		else
			l = x / 2 + 1;
		
		for (int i = x - 1; i >= l; i--) {
			int shots = minMultipliers(i) + 1;
			list1.add(shots);
			list2.add(i);
		}
		int y=1;
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < list1.size(); j++) {
			if (list1.get(j) <= min)
				min = list1.get(j);
				y=list2.get(j);
		}
		if(hmap.get(x-y)==null)
			min++;
		hmap.put(x, min);
		return min;
	}

	public static void main(String args[]) {
		hmap.put(2, 1);
		hmap.put(3, 2);
		int c = minMultipliers(n);
		System.out.println(hmap);
		System.out.println(c);
	}
}