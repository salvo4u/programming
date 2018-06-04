import java.util.ArrayList;
import java.util.HashMap;

public class problem76 {
	static HashMap<Integer, ArrayList<String>> hmap = new HashMap<Integer, ArrayList<String>>();

	static ArrayList<String> mergeList(ArrayList<String> l1,
			ArrayList<String> l2, int n) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < l1.size(); i++) {
			String first = l1.get(i);
			for (int j = 0; j < l2.size(); j++) {
				String second = l2.get(j);
				String s = first + " " + second;
				if (hmap.get(n) == null) {
					list.add(s);
					hmap.put(n, list);
					continue;
				} else {
					if (hmap.get(n).contains(s) == false)
						hmap.get(n).add(s);
				}
			}
		}
		return list;
	}

	static ArrayList<String> getList(int n) {
		ArrayList<String> mainlist = new ArrayList<String>();

		if (n == 1) {
			mainlist.add("1");
			hmap.put(n, mainlist);
			return mainlist;
		}
		if (n == 2) {
			mainlist.add("1 1");
			hmap.put(n, mainlist);
			return mainlist;
		}
		if (n == 3) {
			mainlist.add("1 1 1");
			mainlist.add("1 2");
			hmap.put(n, mainlist);
			return mainlist;
		}

		ArrayList<String> l1, l2, list;

		for (int i = 1; i <= n / 2; i++) {
			if (hmap.get(i) == null)
				l1 = getList(i);
			else
				l1 = hmap.get(i);

			if (hmap.get(n - i) == null)
				l2 = getList(n - i);
			else
				l2 = hmap.get(n - i);

			list = mergeList(l1, l2, n);
			list.add(i + " " + (n - i));
			mainlist.addAll(list);
		}
		hmap.put(n, mainlist);
		System.out.println(n + "----->" + mainlist.size());
		return mainlist;
	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		ArrayList<String> list = getList(6);
		long t2 = System.currentTimeMillis();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println((t2 - t1) + " in ms");
	}
}
