import java.util.ArrayList;
import java.util.List;

class problem55 {
	public static String reverse(String s) {
		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			s1 = s1 + s.charAt(i);
		}
		return s1;
	}

	static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

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
		int flag = 0,count=0;
		String x, n;
		List list = new ArrayList();
		int N=5500;
		for (int j = 1; j <= N; j++) {
			n = j + "";
			flag = 0;
			for (int i = 1; i <= 50; i++) {
				x = add(n + "", reverse(n + ""));
				n = x;
				if (isPalindrome(x + "")) {
					list.add(x);
					flag = 1;
				//	System.out.println(j+"   "+x);
						
					break;
				}
			}
			if (flag == 0)
				{//System.out.println(j+"  ");
					count++;
				}
		}
		System.out.println(count+"  ");
		
	}
}