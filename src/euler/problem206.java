package euler;
import java.math.BigInteger;

public class problem206 {
	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		BigInteger N = new BigInteger(1000000030 + "");
		while (true) {
			BigInteger big = new BigInteger(N + "");
			BigInteger square = big.multiply(big);
			
			if (square.toString().length() > 19)
				break;
			
			char ch = N.toString().charAt(N.toString().length() - 2);
			
			char ch2 = square.toString().charAt(0);
			char ch3 = square.toString().charAt(2);
			char ch4 = square.toString().charAt(4);
			char ch5 = square.toString().charAt(6);
			char ch6 = square.toString().charAt(8);
			char ch7 = square.toString().charAt(10);
			char ch8 = square.toString().charAt(12);
			char ch9 = square.toString().charAt(14);
			char ch10 = square.toString().charAt(16);
			System.out.println(square + "  " + N);
			
			
			if (ch3 == '2' && ch4 == '3' && ch5 == '4' && ch6 == '5'
					&& ch7 == '6' && ch8 == '7' && ch9 == '8' && ch10=='9') {
				System.out.println(square + " --- " + N);
				break;
			}
			if (ch == '3') {
				N = N.add(new BigInteger(40 + ""));
				// System.out.println(N);
			} else if (ch == '7') {
				N = N.add(new BigInteger(60 + ""));
				// System.out.println(N);
			}

			if(N.compareTo(new BigInteger("10000000000"))>=0)
				break;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
