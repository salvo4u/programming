package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
	static HashMap<Integer, ArrayList> hmap = new HashMap<Integer, ArrayList>();

	static long findPaths(int p, int N, ArrayList<Integer> alist) {
		if (alist.contains(p)) {
			System.out.println("INFINITE PATHS");
			System.exit(0);
		}
		if (p == N) {
			// check for special case if path from Nth to earlier node

			ArrayList<Integer> l = hmap.get(p);
			if (l == null)
				return 1;
			for (int i = 0; i < alist.size(); i++) {
				for (int j = 0; j < l.size(); j++) {
					if(l.get(j).equals(alist.get(i))){
						System.out.println("INFINITE PATHS");
						System.exit(0);
					}
				}
			}
			return 1;
		}
		alist.add(p);
		ArrayList<Integer> l = hmap.get(p);
		long count = 0;
		for (Iterator<Integer> iterator = l.iterator(); iterator.hasNext();) {
			Integer i = iterator.next();
			count = count + findPaths(i, N, alist);
		}
		alist.remove((Integer) p);
		return count%1000000000;
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
			long paths = findPaths(1, N, new ArrayList<Integer>());
			System.out.println(paths);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
