import java.util.HashMap;

public class problem56 {
	// to add two numbers using strings a,b are two numbers
	public static HashMap<String, String> h = new HashMap<String, String>();
	public static int gsum = 0;
	public static String power = "";

	public static String add(String a, String b) {
		String sum = "";
		int carry = 0;
		if (a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		for (int i = 0; i < a.length(); i++) {
			int s = a.charAt(a.length() - 1 - i) + b.charAt(b.length() - 1 - i)
					- 96 + carry;
			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;
		}

		for (int i = 0; i < b.length() - a.length(); i++) {
			int s = b.charAt(b.length() - a.length() - 1 - i) + carry - 48;

			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;

		}
		if (carry != 0)
			return carry + sum;
		else
			return sum;
	}

	// to multiply two numbers (any length)
	public static String multiply(String a, String b) {
		int lcarry = 0, pos = 0;
		String finalsum = "0";
		for (int i = b.length() - 1; i >= 0; i--) {
			int digit1 = b.charAt(i) - 48;
			String sum = "", endzeros = "";
			lcarry = 0;
			for (int j = a.length() - 1; j >= 0; j--) {
				int digit2 = a.charAt(j) - 48;
				int mod = (digit1 * digit2 + lcarry) % 10;
				int carry = (digit1 * digit2 + lcarry) / 10;
				sum = mod + sum;
				lcarry = carry;
			}

			for (int j = 0; j < pos; j++)
				endzeros = endzeros + "0";
			pos++;
			sum = lcarry + sum + endzeros;
			// System.out.println(sum+"  "+lcarry);
			finalsum = add(sum, finalsum);
		}
		return finalsum;
	}

	public static String getPower(int a, int b) {
		String res1 = h.get(a + "^" + b);
		// System.out.println(res1);
		if (b == 0)
			return 1 + "";
		if (b == 1)
			return a + "";
		if (b == 2)
			return a * a + "";
		if (b == 3)
			return a * a * a + "";

		if (res1 != null) {
			return res1;
		}
		String r = getPower(a, b / 2);
		String result = multiply(r, r);
		if (b % 2 == 1) {
			result = multiply(result, a + "");
		}
		h.put(a + "^" + b, result);
		// System.out.println(a+"^"+b+"  "+result);
		return result;

	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		int lim = 100;
		for (int i = 2; i < lim; i++) {
			for (int j = 2; j < lim; j++) {
				String x = getPower(i, j);
				int sum = 0;
				for (int k = 0; k < x.length(); k++)
					sum = sum + x.charAt(k) - 48;
				if (sum > gsum) {
					gsum = sum;
					power = i + "^" + j;
					// System.out.println(i+"^"+j+ "  "+x+" -- "+sum);

				}
			}
		}

		System.out.println(power + "  " + gsum);
		long t2 = System.currentTimeMillis();
		

	}
}
