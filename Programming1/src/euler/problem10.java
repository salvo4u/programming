package euler;
public class problem10 {
	public static boolean isPrime(double num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	public static void main(String args[])
	{
		long sum=2;
		for(long i=3;;i=i+2)
		{		
			if(i>2000000)
				break;
			if(isPrime(i))
				sum+=i;
		}
	System.out.println(sum);
	}
}
