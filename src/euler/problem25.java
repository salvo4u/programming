package euler;
public class problem25 {
	//to add two numbers using strings a,b are two numbers
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

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		String s = "2";
		for (int i = 3; i < 2000000; i = i + 2) {
			int flag = 0;
			for (int j = 2; j <= Math.pow(i, .5); j++) {
				if (i % j == 0) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 0){
			System.out.println("------" + i + "-----" + s);
			s = add(s, i + "");
			}
		System.out.print(s);
	}
	}
}
