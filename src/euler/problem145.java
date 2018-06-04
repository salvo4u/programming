package euler;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problem145 {
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

	
	
	public static void main(String args[]) {
		int count = 0;
		HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();
		for (long i = 1; i <= 1000; i++) {
			String number = i + "";
			String reversenumber = new StringBuffer(number).reverse()
					.toString();
			if(reversenumber.startsWith("0"))
				continue;
			String ans = add(number, reversenumber);
			Pattern p = Pattern.compile("[02468]");
			Matcher m = p.matcher(ans);
			Pattern p1 = Pattern.compile("[13579]+");
			Matcher m1 = p1.matcher(ans);
			
			System.out.println(number + "+" + reversenumber + "=" + ans + "  "
					+ (!m.find() && m1.find()));
			if (!m.find() &&m1.find()) {6
				count++;
			}
			
		}
		System.out.println(count);
	}
}
