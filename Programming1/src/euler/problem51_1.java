package euler;
import java.util.HashMap;
import java.util.Vector;


public class problem51_1 {
	public static boolean isPrime(int n1) {
		int num = n1;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		Vector<Integer> v = new Vector<Integer>();
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		int digit=0;
		
		for (int i = 100; i < 1000; i = i + 1) {
		StringBuffer number=new StringBuffer(i+""); 
			for(int j=0;j<10;j++)
			{
				//1.generate the number with 5 digits
				for(int k=0;k<number.length();k++)
				{
					
				}
			}
		}
	}
}
