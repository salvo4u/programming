package random;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Subsets {
	public static void allSubsets(Set<Integer> s) {
		if (s.size() == 0)
			return;
		if (s.size() > 1)
			System.out.println(s.toString());
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			Integer ele = it.next();
			System.out.println(ele);
			s.remove(ele);
			allSubsets(s);
			s.add(ele);
		}

	}

	public static void main(String[] args) {
		Set<Integer> hset = new TreeSet<Integer>();
		hset.add(1);
		hset.add(2);
		hset.add(3);
		allSubsets(hset);
	}
}
