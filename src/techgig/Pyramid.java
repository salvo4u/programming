package techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Pyramid {
	public static HashMap<, V>
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
