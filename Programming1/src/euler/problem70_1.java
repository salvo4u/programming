package euler;
import java.math.BigInteger;
import java.util.Arrays;

public class problem70_1 {
	public static void main(String args[]) {
		int N = 999999;
		int i;
		for (i = N; i > 2; i = i - 2) {
			BigInteger bi = new BigInteger(i + "");
			if (bi.isProbablePrime(8)) {
				String n = i + "";
				String phin = (i - 1) + "";
				char narr[] = n.toCharArray();
				char phinarr[] = phin.toCharArray();
				Arrays.sort(narr);
				Arrays.sort(phinarr);
				n = new String(narr);
				phin = new String(phinarr);
				if (n.equals(phin)) {
					System.out.println(n + "  " + phin + "  " + i);
					break;
				}
			}
		}
	}
}
