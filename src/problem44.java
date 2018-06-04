import java.util.HashMap;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class problem44 {
	public static void main(String args[]) {
		// 1.first set n=1 and iterate on i to find the difference
		HashMap<Long, String> h = new HashMap<Long, String>();
		long minD = Integer.MAX_VALUE;
		Vector<Long> v = new Vector<Long>();
		int arr[] = { 0, 1, 5, 12, 22, 35, 51, 70, 92, 117, 145 };
		for (int n = 1; n < arr.length; n++) {
			for (long i = n; i < arr.length; i++) {
				long number = (n + i) * (3 * n + 3 * i - 1) / 2;
				h.put(number, (n + i) + "");
				long diff = number - arr[n];
				long sum = number + arr[n];
				// check if sum , diff are present as pentagonal numbers or not
				double ks = (1 + Math.sqrt(1 + 24 * sum)) / 6;
				double kd = (1 + Math.sqrt(1 + 24 * diff)) / 6;
				System.out.println(ks + "  " + kd);
				int flags = 0, flagd = 0;
				if (kd - (int) kd == 0) {
					h.put(diff, (int) kd + "");
					flagd = 1;
				}
				if (ks - (int) ks == 0) {
					h.put(sum, (int) ks + "");
					flags = 1;
				}

				if (flags == 1 && flagd == 1) {
					v.add(i);
				}

			}
		}
		System.out.println(h);
		System.out.println(v);
	}
}
