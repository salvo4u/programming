package geeksforgeeks.dp;

import java.util.HashMap;
import java.util.Iterator;

public class RodLength {
	public static HashMap<Integer, Integer> cmap = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

	public static int getMaxofThree(int n1, int n2, int n3) {
		return ((n1 > n2) ? ((n1 > n3) ? n1 : n3) : ((n2 > n3) ? n2 : n3));
	}

	public static int getMaxLength(int n) {
		if (n < 0)
			return 0;
		if (hmap.get(n) != null)
			return hmap.get(n);
		if (n == 0)
			return 0;
		int maxcost = Integer.MIN_VALUE;
		Iterator<Integer> it = cmap.keySet().iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (i > n)
				break;
			int currcost2 = cmap.get(i) + getMaxLength(n - i);
			maxcost = getMaxofThree(maxcost, -1, currcost2);
		}
		hmap.put(n, maxcost);
		return maxcost;
	}

	public static void main(String[] args) {
		cmap.put(1, 1);
		cmap.put(2, 5);
		cmap.put(3, 8);
		cmap.put(4, 9);
		cmap.put(5, 10);
		cmap.put(6, 17);
		cmap.put(7, 17);
		cmap.put(8, 20);
		int max = getMaxLength(8);
		System.out.println(max);
	}
}
