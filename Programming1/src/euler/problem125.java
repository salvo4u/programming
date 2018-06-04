package euler;
import java.util.ArrayList;
import java.util.List;

public class problem125 {
	public static boolean isPalindrome(String string) {
		StringBuffer sb = new StringBuffer(string);
		String reversedCopy = sb.reverse().toString();
		return reversedCopy.equalsIgnoreCase(string);
	}

	public static boolean isSummable(long num) {
		boolean flag = false;
		for (long n = 2; n * n <= num; n++) {
			for (long m = 1; m <= n - 1; m++) {
				long S = (2 * n + 1) * n * (n + 1) / 6 - (m - 1) * m
						* (2 * m - 1) / 6;
				if (S == num)
					return true;
			}
		}
		return flag;
	}

	public static void main(String args[]) {
		double sum = 0;
		long limit = 100000000;
		List<Long> list = new ArrayList<Long>();
		long t1=System.currentTimeMillis();
		for (long i = 1; i <= limit; i++) {
			if (isPalindrome(i + ""))
				list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			if (isSummable(list.get(i))) 
				sum += list.get(i);
			
		}
		System.out.println(sum);
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
		
	}
}
