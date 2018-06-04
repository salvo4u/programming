package euler;
import java.util.Arrays;

public class problem104 {
	// to add two numbers using strings a,b are two numbers
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

	public static boolean satisfies(String s, int a, int b) {
		char arr[] = s.substring(a, b).toCharArray();
		Arrays.sort(arr);
		s = new String(arr);
		if (s.equals("123456789"))
			return true;
		return false;
	}

	public static void main(String[] args) {
		String f1 = "1";
		String f2 = "1";
		String f = "";
		int limit = 542;
		System.out.println(1);
		System.out.println(1);

		for (int n = 3;; n++) {
			f = add(f1, f2);
			System.out.println(n);
			if (f.length() > 9 && satisfies(f, 0, 9)
					&& satisfies(f, f.length() - 9, f.length())) {
				System.out.println("-->" + n);
				break;
			}
			f1 = f2;
			f2 = f;
		}
	}
}
