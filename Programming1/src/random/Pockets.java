package random;

import java.util.Arrays;
import java.util.Comparator;

public class Pockets {
	public static void main(String[] args) {
		String[] sa = { "nickel", "button", "key", "lint" };
		Sorter s = new Sorter();
		for (String s2 : sa)
			System.out.print(s2 + " ");
		Arrays.sort(sa, s);
		System.out.println();
		for (String s2 : sa)
			System.out.print(s2 + " ");
	}

	class Sorter implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}
}