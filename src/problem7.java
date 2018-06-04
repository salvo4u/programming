import java.util.ArrayList;
import java.util.List;

public class problem7 {
	public static boolean isPrime(double num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	public static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String args[])
	{
		primes.add((long)2);
		for(long i=3;;i=i+2)
		{
			if(isPrime(i))
				primes.add(i);
			if(primes.size()==10001)
				break;
		}
	System.out.println(primes.get(10000));
	}
	
}
