import java.util.ArrayList;

public class problem20 {
	// to add two numbers using strings a,b are two numbers
	public static String stringAddition(String a, String b) {
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

	public static String stringMultiplication(String s1, String s2) {
		String zero = "", num = "";
		ArrayList<String> list = new ArrayList<String>();
		for (int i = s1.length() - 1; i >= 0; i--) {
			int carry = 0;
			int c1 = s1.charAt(i) - '0';
			num = "";
			for (int j = s2.length() - 1; j >= 0; j--) {
				int c2 = s2.charAt(j) - '0';
				int prod = c1 * c2 + carry;
				int add = prod % 10;
				carry = prod / 10;
				num = add + num;
			}
			if (carry != 0)
				num = carry + num;
			list.add(num + zero);
			zero = zero + "0";
		}
		num = "0";
		for (int i = 0; i < list.size(); i++)
			num = stringAddition(num, list.get(i));
		return num;
	}

	public static void main(String args[]) {
		String sum="1";
		for (int i = 2; i <= 100; i++) {
			sum=stringMultiplication(sum, i+"");
		}
		int num=0;
		for (int i = 0; i < sum.length(); i++) 
			num+=(sum.charAt(i)-'0');
		System.out.println(num);	
	}
}
