package euler;
import java.util.Vector;

public class problem64 {
	public static void main(String args[]) {
		int count = 0;
		int i = 23;
		for (i = 2; i < 3; i++) {
			i=12;
			double x = Math.sqrt(i);
			int wd = (int) x;
			if (x - wd == 0)
				continue;
			Vector<Integer> v = new Vector<Integer>();
			int a = 1;
			int b = i;
			int c = wd, ap = 1;
			while (true) {
				v.add(wd);
				int d = b - c * c;
		
					d = d / a;
				System.out.println(wd + "  " + a + "," + b + "," + c + "," + d);
				if (d == 1)
					break;
				if (c < d) {
					wd = 1;
					c = d - c;
					a = d;
				} else {
					wd = c;
					c = (d - 1) * c;
					a = d;
				}

			}
			System.out.println(v);
			if (((int) v.size()) % 2 == 1)
				count++;
		}
		System.out.println(count);
	}
}
