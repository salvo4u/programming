package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Kingdom {
	static HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, Integer> hmap1 = new HashMap<Integer, Integer>();

	static int findPaths(int p, int N, ArrayList<Integer> alist) {
		if (alist.contains(p)) {
			System.out.println("INFINITE PATHS");
			System.exit(0);
		}
		
		if (p == N)
			return 1;
		
		if (hmap1.get(p) != null) {
			return hmap1.get(p);
		}
		
		alist.add(p);
		ArrayList<Integer> l = hmap.get(p);
		int count = 0;
		for (Iterator<Integer> iterator = l.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			count = count + findPaths(i, N, alist);
		}
		hmap1.put(p, count);
		alist.remove((Integer) p);
		return count;
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			String arr[] = s.split(" ");
			int N = new Integer(arr[0]);
			int M = new Integer(arr[1]);
			for (int i = 0; i < M; i++) {
				s = br.readLine();
				String s1[] = s.split(" ");
				int x = new Integer(s1[0]);
				int y = new Integer(s1[1]);
				ArrayList<Integer> alist = hmap.get(x);
				if (alist == null) {
					alist = new ArrayList<Integer>();
					alist.add(y);
					hmap.put(x, alist);
				} else
					alist.add(y);
			}
			int paths = findPaths(1, N, new ArrayList<Integer>());
			System.out.println(paths);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
