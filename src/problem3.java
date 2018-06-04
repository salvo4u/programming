import java.util.ArrayList;
import java.util.List;


public class problem3 {
	public static boolean isPrime(double num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static List<Integer> primes = new ArrayList<Integer>();
	private static void initializaPrimes(int N) {
		for (int i = 2; i <= 1000000; i++) {
			if (isPrime(i))
				primes.add(i);
		}
	}
	
	public static void main(String rgp[]) {
		double num=600851475143.0;
			for(int i=2;i<=num/2;i++)
			{
				
			}
	}
}
