import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem70_2 {
	public static boolean isPrime(long num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static List<Long> primes = new ArrayList<Long>();

	public static void main(String args[]) {
		long myi, IN = 10000000;

		for (long i = IN-1; ; i=i-2) {
			if (isPrime(i)) {
				
				String num1 = i + "";
				String num2 = (i - 1) + "";
				
				char arr1[]=num1.toCharArray();
				Arrays.sort(arr1);
				num1=new String(arr1);
				
				char arr2[]=num2.toCharArray();
				Arrays.sort(arr2);
				num2=new String(arr2);
				//System.out.println(i+"  "+num1+"  "+num2);
					if(num1.equalsIgnoreCase(num2))
					{
						System.out.println(i);
						break;
					}
			}
		}
	}
}
