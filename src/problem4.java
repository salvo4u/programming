
public class problem4 {

	public static boolean isPalind(int n) {
		String num = n + "";
		for (int j = 0; j < num.length(); j++) {
			if (num.charAt(j) != num.charAt(num.length() - 1 - j))
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		int max=Integer.MIN_VALUE;	
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				int prod = i * j;
				if (isPalind(prod)) {
					if(max<prod)
						max=prod;
				}
			}
		}
		System.out.println(max);
	}
}
