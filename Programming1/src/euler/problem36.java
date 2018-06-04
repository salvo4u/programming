package euler;
public class problem36 {
	public static String toBinary(int n) {
		String x = "";
		while (n != 0) {
			int mod = n % 2;
			n = n / 2;
			x = mod + x;
		}
		return x;
	}

	static public boolean isPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		int sum = 0;
		for (int i = 1; i < 1000000; i = i + 2) {
			String binary = toBinary(i);
			String number = i + "";
			if (isPalindrome(number) && isPalindrome(binary)) 
				sum += i;
			
		}
	System.out.println(sum);
	}
}
