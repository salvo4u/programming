package euler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class problem49 {
	public static int isPrime(int n1) {
		int num = n1;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return i;
		}
		return 0;
	}



	public static String hashKey(int x) {
		String p = x + "", x1 = "";
		char arr[] = new char[p.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = p.charAt(i);

		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			x1 = x1 + arr[i];
		}
		//System.out.println(p + "  " + x1);
		return x1;
	}

	public static void main(String args[]) {
		List<Integer> pl = new ArrayList<Integer>();
		for (int i = 1001; i < 9999; i = i + 2) {
			if (isPrime(i) == 0)
				pl.add(i);
		}

		for (int i = 0; i < pl.size(); i++) {
			int p1 = (Integer) pl.get(i);
			String k1 = hashKey(p1);
			for (int j = i + 1; j < pl.size(); j++) {
				int p2 = (Integer) pl.get(j);
				String k2 = hashKey(p2);
				if (k1.equals(k2)) {
					for (int k = j + 1; k < pl.size(); k++) {
						int p3 = (Integer) pl.get(k);
						String k3 = hashKey(p3);
						if (p2 - p1 == p3 - p2 	&& k2.equals(k3))
							System.out.println(p1 + "  " + p2 + "  " + p3);
					}
				}
			}
		}
	}
}