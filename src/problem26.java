public class problem26 {
	public static void main(String args[]) {
		int n = 1;
		int d = 7;
		String s = "";
		while (true) {
			n *= 10;
			int r = n % d;
			int q = (n - r) / d;
			if (r == 0) {
				s += r;
				break;
			}

		}
	}
}
